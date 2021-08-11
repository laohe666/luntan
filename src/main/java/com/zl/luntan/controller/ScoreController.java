package com.zl.luntan.controller;

import com.zl.luntan.common.enums.ComEnums;
import com.zl.luntan.dal.dto.ScoreRsp;
import com.zl.luntan.dal.entity.Score;
import com.zl.luntan.service.impl.ScoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/8/2 22:25
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Controller
public class ScoreController {

    @Autowired
    private ScoreServiceImpl scoreService;


    /**
     * 展示所有未删除的黑分
     * */
    @PostMapping("/showAllNScore")
    @ResponseBody
    public ScoreRsp showAllN(int pageNum, int pageSize){
        ScoreRsp rsp = new ScoreRsp();
        //查询所有未删除的黑分
//        try {
            rsp = scoreService.selectNAll(pageNum, pageSize);
            rsp.setMsg("成功");
            rsp.setState(ComEnums.STATE_Y);
//        } catch (Exception e){
//            rsp.setMsg("失败");
//            rsp.setState(ComEnums.STATE_N);
//            return rsp;
//        }
        return rsp;
    }
}
