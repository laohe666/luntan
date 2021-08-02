package com.zl.luntan.dal.entity;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/8/2 22:47
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Data
public class Assure {

    private int asId;

    private String regAddr;

    private String loginAddr;

    private String name;

    private String imgUrl;

    private String des;

    private String isDel;

    private String upTime;

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }
}
