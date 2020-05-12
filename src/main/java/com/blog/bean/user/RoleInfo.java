package com.blog.bean.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ZXP on 2020/4/26 15:01
 */
@Data
@Accessors(chain = true)
public class RoleInfo extends Model<RoleInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     * @author ZXP
     * @Date 2020-04-26 15:10
     */
    @TableField("id")
    private Integer id;

    /**
     * 角色名
     * @author ZXP
     * @Date 2020-04-26 15:10
     */
    @TableField("role_name")
    private String roleName ;

    /**
     * status
     * @author ZXP
     * @Date 2020-04-26 15:10
     */
    @TableField("status")
    private int status;

    /**
     * 角色描述
     * @author ZXP
     * @Date 2020-04-26 15:10
     */
    @TableField("desc")
    private String desc;

    /**
     * 创建时间
     * @author ZXP
     * @Date 2020-04-26 15:10
     */
    @TableField("create_time")
    private Date createTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
