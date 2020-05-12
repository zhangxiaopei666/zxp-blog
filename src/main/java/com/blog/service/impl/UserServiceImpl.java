package com.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.bean.user.UserInfo;
import com.blog.mapper.UserDao;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ZXP on 2020/4/25 15:29
 */
@Service
public class UserServiceImpl  extends ServiceImpl<UserDao, UserInfo> implements UserService {

    @Autowired
    UserDao dao;

    @Override
    public UserInfo login(UserInfo user) {
        UserInfo userInfo = dao.login(user);
        return userInfo;
    }

}
