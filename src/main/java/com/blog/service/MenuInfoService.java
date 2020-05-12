package com.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.bean.request.user.MenuRequest;
import com.blog.bean.response.user.MenuList;
import com.blog.bean.user.MenuInfo;

import java.util.List;

/**
 * Created by ZXP on 2020/4/26 15:48
 */
public interface MenuInfoService extends IService<MenuInfo> {

    /**
     * 获取用户拥有的菜单
     * @author ZXP
     * @Date 2020-04-27 15:03
     */
    List<MenuList> getMenuList(Integer userId);

    /**
     * 根据id集合查询菜单信息
     * @author ZXP
     * @Date 2020-04-27 15:04
     */
    List<MenuInfo> getMenuByIds(List<Integer> menuIds);

    /**
     * 转换菜单树
     * @author ZXP
     * @Date 2020-04-27 15:04
     */
    List<MenuList> pojoToResult(List<MenuInfo> menus);

    /**
     * 菜单管理列表
     * @author ZXP
     * @Date 2020-04-26 15:59
     */
    Page<MenuInfo> management(MenuRequest.PageRequest request);
}
