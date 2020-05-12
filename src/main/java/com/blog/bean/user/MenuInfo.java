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
public class MenuInfo extends Model<MenuInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     * @author ZXP
     * @Date 2020-04-26 15:08
     */
    @TableField("id")
    private Integer id;

    /**
     * 菜单名
     * @author ZXP
     * @Date 2020-04-26 15:08
     */
    @TableField("menu_name")
    private String menuName;

    /**
     * 菜单层级
     * @author ZXP
     * @Date 2020-04-26 15:08
     */
    @TableField("path")
    private String path;

    /**
     * 跳转链接
     * @author ZXP
     * @Date 2020-04-26 15:08
     */
    @TableField("link_url")
    private String linkUrl;

    /**
     * 状态
     * @author ZXP
     * @Date 2020-04-26 15:08
     */
    @TableField("status")
    private int status;

    /**
     * 父id
     * @author ZXP
     * @Date 2020-04-26 15:08
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 创建时间
     * @author ZXP
     * @Date 2020-04-26 15:08
     */
    @TableField("create_time")
    private Date createTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
