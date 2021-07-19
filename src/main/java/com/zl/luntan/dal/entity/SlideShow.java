package com.zl.luntan.dal.entity;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/14 18:44
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Data
@Accessors
public class SlideShow {
    /**
     * 主键
     * */
    private int id;

    /**
     * 轮播图上传路径
     * */
    private String slideImg;

    /**
     * 注册地址
     * */
    private String regAddr;

    /**
     * 登陆地址
     * */
    private String loginAddr;

    /**
     * 更新时间
     * */
    private String up_time;

    /**
     * 是否删除
     * */
    private String isDel;

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }
}
