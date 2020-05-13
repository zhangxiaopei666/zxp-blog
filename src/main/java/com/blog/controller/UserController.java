package com.blog.controller;

import com.blog.bean.common.ResponseBean;
import com.blog.bean.user.UserInfo;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ZXP on 2020/4/25 15:11
 */
@RestController
@RequestMapping("/user-info")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/login")
    public ResponseBean login(@RequestBody UserInfo userInfo){
        UserInfo loginUserInfo = service.login(userInfo);
        if(loginUserInfo==null){
            return ResponseBean.fail("用户名或密码错误");
        }
        return ResponseBean.success(loginUserInfo,"登陆成功");
    }

    @GetMapping("/getCurrentUser")
    public ResponseBean getCurrentUser(){
        User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseBean.success(loginUser,"操作成功");
    }


}
