package com.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.bean.common.ResponseBean;
import com.blog.bean.request.user.MenuRequest;
import com.blog.bean.response.user.MenuList;
import com.blog.bean.user.MenuInfo;
import com.blog.bean.user.UserInfo;
import com.blog.service.MenuInfoService;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ZXP on 2020/4/26 15:45
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuInfoService service;

    @Autowired
    UserService userService;

    /**
     * 根据用户id获取用户菜单信息
     * @author ZXP
     * @Date 2020-04-26 15:59
     */
    @GetMapping("/getMenuList")
    public ResponseBean getMenuList(@RequestParam("userTel") String userTel){
        UserInfo userInfo = userService.getByTel(userTel);
        List<MenuList> result =  service.getMenuList(userInfo.getId());
        return ResponseBean.success(result,"操作成功");
    }

    /**
     * 菜单管理列表
     * @author ZXP
     * @Date 2020-04-26 15:59
     */
    @PostMapping("/management")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseBean management(@RequestBody MenuRequest.PageRequest request){
        Page<MenuInfo> result =  service.management(request);
        return ResponseBean.success(result,"操作成功");
    }

    /**
     * 根据id查询菜单信息
     * @author ZXP
     * @Date 2020-04-26 15:59
     */
    @GetMapping("/getById")
    public ResponseBean getById(Integer menuId){
        MenuInfo menuInfo = service.getById(menuId);
        return ResponseBean.success(menuInfo,"操作成功");
    }

    /**
     * 根据id更新菜单信息
     * @author ZXP
     * @Date 2020-04-26 15:59
     */
    @PostMapping("/updateById")
    public ResponseBean updateById(@RequestBody MenuInfo menuInfo){
        boolean b = service.updateById(menuInfo);
        return ResponseBean.success(b,"操作成功");
    }
}
