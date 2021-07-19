package com.zl.luntan.dal.dto;

import com.auth0.jwt.JWT;
import com.zl.luntan.dal.entity.User;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/10 22:43
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Data
@Accessors
public class UserRsp implements Serializable {
    /**
     * 返回消息
     * */
    private String msg;

    /**
     * 返回用户列表
     * */
    private List<User> userList;

    /**
     * 返回用户对象
     * */
    private User user;

    /**
     * 返回token  JWT
     * */
    private String token;

    /**
     * 返回状态码
     * */
    private String state;


}
