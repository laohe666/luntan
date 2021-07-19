package com.zl.luntan.dal.entity;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/9 16:57
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Data
@Accessors
public class User implements Serializable {

    /**
     *  主键
     * */

    private int uId;

    /**
     *  邮箱
     * */
    private String email;

    /**
     * 密码
     * */
    private String password;

    /**
     * 昵称
     * */
    private String nickname;

    /**
     * 头像
     * */
    private String headPhoto;

    /**
     * 注册时间
     * */
    private String regTime;

    /**
     * 登陆时间
     * */
    private String loginTime;

    /**
     * 是否删除
     * */
    private String isDel;

    /**
     * 更新时间
     * */
    private String upTime;

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }

}
