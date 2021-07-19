package com.zl.luntan.dal.dto;

import com.alibaba.fastjson.JSON;
import com.zl.luntan.dal.entity.Talk;
import lombok.Data;

import java.util.List;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/18 11:48
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Data
public class TalkRsp {

    private String msg;

    private String state;

    private List<Talk> talks;

    private Talk talk;

    private Long total;

    @Override
    public String toString(){
        return JSON.toJSONString("this");
    }
}
