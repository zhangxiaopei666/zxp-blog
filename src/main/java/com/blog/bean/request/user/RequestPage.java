package com.blog.bean.request.user;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by ZXP on 2020/4/29 14:39
 */
@Data
public class RequestPage  implements Serializable {

    private Integer current;

    private Integer size;
}
