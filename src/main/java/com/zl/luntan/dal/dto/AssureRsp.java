package com.zl.luntan.dal.dto;

import com.alibaba.fastjson.JSON;
import com.zl.luntan.dal.entity.Assure;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/8/3 16:22
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Data
public class AssureRsp implements Serializable {

    private String state;

    private String msg;

    private Assure assure;

    private List<Assure> assures;

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }
}
