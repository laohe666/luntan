package com.zl.luntan.dal.entity;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/12 9:31
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Data
@Accessors
public class WebType implements Serializable {

    /**
     * w_id
     * */
    private int wId;

    /**
     * type_name分类名称
     * */
    private String typeName;

    /**
     * web_Img分类图片
     * */
    private String webImg;

    /**
     * 描述
     * */
    private String des;

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
