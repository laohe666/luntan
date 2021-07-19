package com.zl.luntan.dal.dto;

import com.alibaba.fastjson.JSON;
import com.zl.luntan.dal.entity.SlideShow;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/15 14:17
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Data
@Accessors
public class SlideShowRsp {

    private String msg;

    private String state;

    private List<SlideShow> showList;

    private SlideShow slideShow;

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }

}
