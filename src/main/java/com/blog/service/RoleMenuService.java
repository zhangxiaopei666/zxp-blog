package com.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.bean.user.RoleMenu;

import java.util.List;

/**
 * Created by ZXP on 2020/4/26 15:48
 */
public interface RoleMenuService extends IService<RoleMenu> {

    /**
     * 根据用户id获取对应的角色id集合
     * @author ZXP
     * @Date 2020-04-27 14:48
     */
    List<Integer> getMenuIdsByRoleIds(List<Integer> roleIds);
}
