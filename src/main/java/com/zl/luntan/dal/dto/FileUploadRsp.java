package com.zl.luntan.dal.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/13 21:03
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Data
@Accessors
public class FileUploadRsp {

    //返回状态
    private String state;

    //返回消息
    private String msg;

    //返回服务器存储路径
    private String imgUrl;

}
