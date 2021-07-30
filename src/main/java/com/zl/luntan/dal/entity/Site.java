package com.zl.luntan.dal.entity;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/12 22:06
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Data
@Accessors
public class Site implements Serializable {

    /**
     * 主键
     * */
    private int sId;

    /**
     * 网站类型外键
     * */
    private int wId;

    /**
     *网站名称
     * */
    private String siteName;

    /**
     * 网站图片
     * */
    private String siteImg;

    /**
     * 描述
     * */
    private String des;

    /**
     * 更新时间
     * */
    private String upTime;

    /**
     * 登陆地址
     * */
    private String loginAddr;

    /**
     * 注册地址
     * */
    private String regAddr;

    /**
     * 是否删除
     * */
    private String isDel;

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }

}
