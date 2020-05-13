package com.blog.bean.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Created by ZXP on 2020/4/25 15:07
 */
@Data
@Accessors(chain = true)
public class UserInfo extends Model<UserInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     * @author ZXP
     * @Date 2020-04-26 15:11
     */
    @TableField("id")
    private Integer id;

    /**
     * 用户名
     * @author ZXP
     * @Date 2020-04-26 15:11
     */
    @TableField("username")
    private String username;

    /**
     * 手机号
     * @author ZXP
     * @Date 2020-04-26 15:11
     */
    @TableField("tel")
    private String tel;

    /**
     * 密码
     * @author ZXP
     * @Date 2020-04-26 15:11
     */
    @TableField("password")
    private String password;

    /**
     * 创建时间
     * @author ZXP
     * @Date 2020-04-26 15:11
     */
    @TableField("create_time")
    private Date createTime;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
