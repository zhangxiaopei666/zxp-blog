package com.blog.bean.response.user;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by ZXP on 2020/4/27 14:39
 */
@Data
public class MenuList implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     * @author ZXP
     * @Date 2020-04-26 15:08
     */
    private Integer id;

    /**
     * 菜单名
     * @author ZXP
     * @Date 2020-04-26 15:08
     */
    private String menuName;

    /**
     * 菜单层级
     * @author ZXP
     * @Date 2020-04-26 15:08
     */
    private String path;

    /**
     * 跳转链接
     * @author ZXP
     * @Date 2020-04-26 15:08
     */
    private String linkUrl;

    /**
     * 父id
     * @author ZXP
     * @Date 2020-04-26 15:08
     */
    private Integer parentId;

    /**
     * 子集菜单
     * @author ZXP
     * @Date 2020-04-27 14:43
     */
    private List<MenuList> childList;

}
