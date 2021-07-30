package com.zl.luntan.dal.entity;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/15 15:39
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Data
@Accessors
public class Talk implements Serializable {
    /**
     * 主键
     */
    private int tId;

    /**
     * 用户
     * */
    private User user;

    /**
     * 发布内容
     * */
    private String context;

    /**
     * 描述
     * */
    private String des;

    /**
     * 状态
     * */
    private String state;

    /**
     * 发送时间
     * */
    private String sendTime;

    /**
     * 更新时间
     * */
    private String upTime;

    /**
     * 是否删除
     * */
    private String isDel;



    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }

}
