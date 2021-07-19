package com.zl.luntan.controller;

import com.zl.luntan.common.enums.ComEnums;
import com.zl.luntan.dal.dto.WebTypeRsp;
import com.zl.luntan.dal.entity.WebType;
import com.zl.luntan.service.impl.WebTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/12 10:20
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Controller
public class WebTypeController {
    @Autowired
    private WebTypeServiceImpl webTypeService;

    /**
     * 客户端展示分类
     * */
    @ResponseBody
    @GetMapping("/showAllNWT")
    public WebTypeRsp showAllNWT(){
        WebTypeRsp rsp = new WebTypeRsp();
        //查询数据库数据
        try {
            List<WebType> webTypes = webTypeService.selectNAllWT();
            rsp.setWebTypes(webTypes);
            rsp.setMsg("查询成功");
            rsp.setState(ComEnums.STATE_Y);
        }catch (Exception e){
            rsp.setMsg("查询错误");
            rsp.setState(ComEnums.STATE_N);
            return rsp;
        }
        return rsp;
    }
}
