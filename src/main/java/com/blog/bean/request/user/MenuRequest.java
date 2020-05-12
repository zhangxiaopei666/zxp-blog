package com.blog.bean.request.user;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by ZXP on 2020/4/29 14:40
 */
@Data
public class MenuRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Data
    public static class PageRequest extends RequestPage {

        private static final long serialVersionUID = 1L;

        private String menuName;
    }
}
