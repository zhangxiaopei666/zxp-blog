package com.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.bean.user.UserInfo;

/**
 * Created by ZXP on 2020/4/25 15:29
 */
public interface UserService extends IService<UserInfo>{

    UserInfo login(UserInfo userInfo);

    UserInfo getByTel(String tel);
}
