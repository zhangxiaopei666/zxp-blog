package com.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.bean.user.UserRole;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZXP on 2020/4/26 15:51
 */
@Repository
public interface UserRoleDao  extends BaseMapper<UserRole> {

    @Select(" select role_id from user_role where user_id=#{userId} ")
    List<Integer> getRoleIdsByUserId(Integer userId);
}
