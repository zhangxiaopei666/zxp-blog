package com.blog.bean.common;

import lombok.Data;

/**
 * 响应消息bean
 * Created by ZXP on 2020/4/25 15:11
 */
@Data
public class ResponseBean {

    /**
     * 响应数据
     *
     * @author ZXP
     * @Date 2020-04-25 15:12
     */
    private Object data;
    /**
     * 请求状态
     *
     * @author ZXP
     * @Date 2020-04-25 15:13
     */
    private Boolean isSuccess;

    /**
     * 响应码
     *
     * @author ZXP
     * @Date 2020-04-25 15:13
     */
    private Integer code;

    /**
     * 提示信息
     *
     * @author ZXP
     * @Date 2020-04-25 15:13
     */
    private String message;

    private ResponseBean(Integer code, Boolean isSuccess, Object data, String message) {
        this.code = code;
        this.isSuccess = isSuccess;
        this.data = data;
        this.message = message;
    }

    public static ResponseBean success(Object data, String message) {
        return new ResponseBean(200, true, data, message);
    }

    public static ResponseBean fail(String message) {
        return new ResponseBean(500, false, null, message);
    }
}
