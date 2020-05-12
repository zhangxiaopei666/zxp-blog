package com.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.bean.request.user.MenuRequest;
import com.blog.bean.response.user.MenuList;
import com.blog.bean.user.MenuInfo;
import com.blog.mapper.MenuInfoDao;
import com.blog.service.MenuInfoService;
import com.blog.service.RoleMenuService;
import com.blog.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ZXP on 2020/4/26 15:48
 */
@Service
public class MenuInfoServiceImpl extends ServiceImpl<MenuInfoDao, MenuInfo> implements MenuInfoService {

    @Autowired
    UserRoleService userRoleService;
    @Autowired
    RoleMenuService roleMenuService;

    /**
     * 获取用户拥有的菜单
     *
     * @author ZXP
     * @Date 2020-04-27 15:03
     */
    @Override
    public List<MenuList> getMenuList(Integer userId) {
        //查询用户拥有的角色
        List<Integer> roleIds = userRoleService.getRoleIdsByUserId(userId);
        if (roleIds == null) {
            return null;
        }
        //查询角色对应的菜单
        List<Integer> menuIds = roleMenuService.getMenuIdsByRoleIds(roleIds);
        //根据菜单id集合查询菜单信息
        if (menuIds == null) {
            return null;
        }
        List<MenuInfo> menuInfos = this.getMenuByIds(menuIds);
        List<MenuList> menuLists = this.pojoToResult(menuInfos);
        //递归封装结果
        List<MenuList> result = packMenu(menuLists, 0);
        return result;
    }

    /**
     * 递归封装 菜单树
     *
     * @author ZXP
     * @Date 2020-04-29 13:12
     */
    public List<MenuList> packMenu(List<MenuList> menuInfos, Integer parentId) {
        List<MenuList> result = new LinkedList<>();
        for (MenuList menu : menuInfos) {
            if (parentId.equals(menu.getParentId())) {
                menu.setChildList(packMenu(menuInfos, menu.getId()));
                result.add(menu);
            }
        }
        return result;
    }

    /**
     * 根据id集合查询菜单信息
     *
     * @author ZXP
     * @Date 2020-04-27 15:04
     */
    @Override
    public List<MenuInfo> getMenuByIds(List<Integer> menuIds) {
        QueryWrapper<MenuInfo> query = new QueryWrapper<>();
        query.lambda().in(MenuInfo::getId, menuIds)
                .eq(MenuInfo::getStatus, 1);
        List<MenuInfo> menuInfos = super.list(query);
        return menuInfos;
    }

    /**
     * 转换菜单树
     *
     * @author ZXP
     * @Date 2020-04-27 15:04
     */
    @Override
    public List<MenuList> pojoToResult(List<MenuInfo> menus) {
        if (menus == null) {
            return null;
        }

        List<MenuList> result = new LinkedList<>();
        menus.forEach(i -> {
            MenuList menuList = new MenuList();
            menuList.setId(i.getId());
            menuList.setPath(i.getPath());
            menuList.setLinkUrl(i.getLinkUrl());
            menuList.setMenuName(i.getMenuName());
            menuList.setParentId(i.getParentId());
            result.add(menuList);
        });
        return result;
    }

    /**
     * 菜单管理列表
     *
     * @author ZXP
     * @Date 2020-04-26 15:59
     */
    @Override
    public Page<MenuInfo> management(MenuRequest.PageRequest request) {
        Integer current = request.getCurrent();
        Integer size = request.getSize();
        QueryWrapper<MenuInfo> query = new QueryWrapper<>();
        query.lambda().eq(MenuInfo::getStatus, 1)
                .likeRight(StringUtils.isNotBlank(request.getMenuName()),MenuInfo::getMenuName,request.getMenuName());
        Page<MenuInfo> page = super.page(new Page<>(current, size), query);
        return page;
    }

}
