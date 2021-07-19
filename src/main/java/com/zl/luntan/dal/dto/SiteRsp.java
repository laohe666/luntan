package com.zl.luntan.dal.dto;

import com.alibaba.fastjson.JSON;
import com.zl.luntan.dal.entity.Site;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/13 21:40
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Data
@Accessors
public class SiteRsp {
    /**
     * 返回消息
     * */
    private String msg;

    /**
     * 返回Site列表
     * */
    private List<Site> siteList;

    /**
     * 单个Site对象
     * */
    private Site site;

    /**
     * 返回状态
     * */
    private String state;

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }
}
