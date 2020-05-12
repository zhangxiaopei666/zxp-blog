package com.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.bean.user.UserRole;
import com.blog.mapper.UserRoleDao;
import com.blog.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by ZXP on 2020/4/26 15:48
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleDao, UserRole> implements UserRoleService {

    @Autowired
    UserRoleDao dao;

    /**
     * 根据用户id获取对应的角色id集合
     * @author ZXP
     * @Date 2020-04-27 14:48
     */
    @Override
    public List<Integer> getRoleIdsByUserId(Integer userId) {
        List<Integer> roleIds = dao.getRoleIdsByUserId(userId);
        if (CollectionUtils.isEmpty(roleIds)){
            return null;
        }
        return roleIds;
    }
}
