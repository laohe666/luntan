package com.zl.luntan.controller;

import com.zl.luntan.common.enums.ComEnums;
import com.zl.luntan.dal.dto.AssureRsp;
import com.zl.luntan.dal.entity.Assure;
import com.zl.luntan.service.impl.AssureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/8/3 16:19
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Controller
public class AssureController {
    @Autowired
    private AssureServiceImpl assureService;

    /**
     * 查询所有未删除的担保网站
     **/
    @ResponseBody
    @PostMapping("/showAllNAssure")
    public AssureRsp showAllNAssur(){
        AssureRsp rsp = new AssureRsp();
        //查询所有的未删除的担保平台
        try {
            List<Assure> assures = assureService.selectAllNAssure();
            rsp.setAssures(assures);
            rsp.setState(ComEnums.STATE_Y);
            rsp.setMsg("查询成功");
        } catch (Exception e){
            rsp.setMsg("失败");
            rsp.setState(ComEnums.STATE_N);
            return rsp;
        }
        return rsp;
    }
}
