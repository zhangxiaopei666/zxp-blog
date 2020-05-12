package com.blog.bean.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 用户角色关联表
 * Created by ZXP on 2020/4/26 15:01
 */
@Data
@Accessors(chain = true)
public class UserRole extends Model<UserRole> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     * @author ZXP
     * @Date 2020-04-26 15:13
     */
    @TableField("id")
    private Integer id;

    /**
     * 用户id
     * @author ZXP
     * @Date 2020-04-26 15:13
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 角色id
     * @author ZXP
     * @Date 2020-04-26 15:13
     */
    @TableField("role_id")
    private Integer roleId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
