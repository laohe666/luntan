package com.zl.luntan.dal.dto;

import com.zl.luntan.dal.entity.WebType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/12 10:22
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Data
@Accessors
public class WebTypeRsp {

    /**
     * 返回列表
     * */
    private List<WebType> webTypes;

    /**
     * 响应消息
     * */
    private String msg;

    /**
     * 响应状态
     * */
    private String state;

    /**
     * 响应
     * */


}
