package com.zl.luntan.controller;

import com.zl.luntan.common.enums.ComEnums;
import com.zl.luntan.dal.dto.SlideShowRsp;
import com.zl.luntan.dal.entity.SlideShow;
import com.zl.luntan.service.impl.SlideShowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/15 14:16
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Controller
public class SlideShowController {

    @Autowired
    private SlideShowServiceImpl slideShowService;

    /**
     * 展示所有未删除的轮播图
     * */
    @ResponseBody
    @RequestMapping("/showNSlide")
    public SlideShowRsp showSlide(){
        SlideShowRsp rsp = new SlideShowRsp();
        //展示所有轮播图
        try {
            List<SlideShow> showList = slideShowService.selectAllNSlide();
            rsp.setMsg("查询轮播图成功");
            rsp.setShowList(showList);
            rsp.setState(ComEnums.STATE_Y);
        } catch (Exception e){
            rsp.setMsg("轮播图查询失败");
            rsp.setState(ComEnums.STATE_N);
            return rsp;
        }
        return rsp;
    }
}
