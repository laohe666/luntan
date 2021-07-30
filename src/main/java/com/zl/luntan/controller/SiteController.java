package com.zl.luntan.controller;

import com.zl.luntan.common.enums.ComEnums;
import com.zl.luntan.dal.dto.SiteRsp;
import com.zl.luntan.dal.entity.Site;
import com.zl.luntan.service.impl.SiteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/13 18:37
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Controller
public class SiteController {

    @Autowired
    private SiteServiceImpl siteService;

    /**
     *
     */
    @ResponseBody
    @PostMapping("")
    public SiteRsp addSite(){
        SiteRsp siteRsp = new SiteRsp();


        return siteRsp;
    }

    /**
     * 前端网站展示列表
     * */
    @ResponseBody
    @PostMapping("/showNSite")
    public SiteRsp showNSite(int wId){
        System.out.println(wId);
        SiteRsp rsp = new SiteRsp();
        // 查询所有的未被删除的网站
        try {
            List<Site> sites = siteService.selectNSites(wId);
            rsp.setMsg("查询成功");
            rsp.setSiteList(sites);
            rsp.setState(ComEnums.STATE_Y);
        } catch (Exception e){
            rsp.setMsg("查询出错");
            rsp.setState(ComEnums.STATE_N);
            return rsp;
        }
        //返回响应
        return rsp;
    }

    /**
     *
     * */
    
}
