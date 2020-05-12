package com.blog.bean.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created by ZXP on 2020/4/26 15:01
 */
@Data
@Accessors(chain = true)
public class RoleMenu extends Model<RoleMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     * @author ZXP
     * @Date 2020-04-26 15:14
     */
    private Integer id;

    /**
     * 角色id
     * @author ZXP
     * @Date 2020-04-26 15:13
     */
    @TableField("role_id")
    private Integer roleId;

    /**
     * 菜单id
     * @author ZXP
     * @Date 2020-04-26 15:13
     */
    @TableField("menu_id")
    private Integer menuId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
