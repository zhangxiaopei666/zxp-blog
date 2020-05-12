package com.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.bean.user.RoleInfo;
import com.blog.mapper.RoleInfoDao;
import com.blog.service.RoleInfoService;
import com.blog.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZXP on 2020/4/26 15:48
 */
@Service
public class RoleInfoServiceImpl extends ServiceImpl<RoleInfoDao, RoleInfo> implements RoleInfoService {

}
