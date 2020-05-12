package com.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.bean.user.UserInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by ZXP on 2020/4/25 15:30
 */
@Repository
public interface UserDao extends BaseMapper<UserInfo> {


    @Select("select id,username from user_info where tel=#{tel} and password=#{password}")
    UserInfo login(UserInfo userInfo);
}
