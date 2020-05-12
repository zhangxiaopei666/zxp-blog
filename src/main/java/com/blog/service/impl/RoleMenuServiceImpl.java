package com.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.bean.user.RoleMenu;
import com.blog.mapper.RoleMenuDao;
import com.blog.service.RoleMenuService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ZXP on 2020/4/26 15:48
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuDao, RoleMenu> implements RoleMenuService {

    @Override
    public List<Integer> getMenuIdsByRoleIds(List<Integer> roleIds) {
        QueryWrapper<RoleMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .select(RoleMenu::getMenuId)
                .in(RoleMenu::getRoleId,roleIds);
        List<RoleMenu> list = super.list(queryWrapper);
        if (CollectionUtils.isEmpty(list)){
            return null;
        }
        List<Integer> menuIds = list.parallelStream().map(RoleMenu::getMenuId)
                .collect(Collectors.toList());
        return menuIds;
    }

}
