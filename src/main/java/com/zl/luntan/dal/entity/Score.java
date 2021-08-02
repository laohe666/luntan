package com.zl.luntan.dal.entity;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/8/1 21:40
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Data
public class Score {

    /**
     * 主键
     * */
    private int scId;

    /**
     * 描述
     * */
    private String des;

    /**
     * 地址
     * */
    private String addr;

    /**
     * 状态 是否担保
     * */
    private String state;

    /**
     * 网站名称
     * */
    private String name;

    /**
     * 是否删除
     * */
    private String isDel;

    /**
     * 更新时间
     * */
    private String upTime;

    /**
     * 网站图片
     * */
    private String scoreImg;

    /**
     * 黑分标题
     * */
    private String title;

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }
}
