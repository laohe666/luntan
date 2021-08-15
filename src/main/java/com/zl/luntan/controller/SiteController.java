package com.zl.luntan.controller;

import com.zl.luntan.common.enums.ComEnums;
import com.zl.luntan.common.util.FileUpload;
import com.zl.luntan.common.util.StringUtils;
import com.zl.luntan.dal.dao.SiteDao;
import com.zl.luntan.dal.dto.FileUploadRsp;
import com.zl.luntan.dal.dto.SiteRsp;
import com.zl.luntan.dal.entity.Site;
import com.zl.luntan.service.impl.SiteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @Autowired
    private SiteDao siteDao;

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
     * 后台查询所有的
     * */
    @ResponseBody
    @GetMapping("/selectSite")
    public SiteRsp selectSites(){
        SiteRsp rsp = new SiteRsp();
        List<Site> sites = siteDao.selectAll();
        rsp.setSiteList(sites);
        rsp.setMsg("查询成功");
        return rsp;
    }

    /**
     * 修改所有的
     * */
    @ResponseBody
    @PostMapping("/updateSite")
    public SiteRsp updateSite(@RequestBody Site site){
        SiteRsp rsp = new SiteRsp();
        if(!siteService.updSite(site)){
            rsp.setMsg("修改失败");
            return rsp;
        }
        rsp.setMsg("修改成功");
        return rsp;
    }

    /**
     * 修改网站图片
     * */
    @ResponseBody
    @PostMapping("/updateSiteImg")
    public SiteRsp updateSiteImg(@RequestParam("file") MultipartFile file,String sId){
        SiteRsp rsp = new SiteRsp();
        if(file.isEmpty()){
            rsp.setMsg("图片为空");
            return rsp;
        }
        FileUploadRsp fileUploadRsp = FileUpload.uploadFile(file);
        if(ComEnums.STATE_N.equals(fileUploadRsp.getState())){
            rsp.setMsg("文件上传时失败");
            return rsp;
        }
        Site site = new Site();
        site.setSiteImg(fileUploadRsp.getImgUrl());
        site.setUpTime(StringUtils.getNowTM());
        site.setSId(Integer.parseInt(sId));
        if(siteDao.updateSiteImg(site) != 1){
            rsp.setMsg("更新失败");
            return rsp;
        }
        rsp.setMsg("更新成功");
        return rsp;
    }

    /**
     * 增加
     * */
    @ResponseBody
    @RequestMapping("/addSite")
    public SiteRsp addSite(@RequestParam("file") MultipartFile file, String siteName, String des, String loginAddr, String regAddr,String wId){
        SiteRsp rsp = new SiteRsp();
        if(file.isEmpty()){
            rsp.setMsg("文件是空");
            return rsp;
        }
        FileUploadRsp fileUploadRsp = FileUpload.uploadFile(file);
        Site site = new Site();
        site.setUpTime(StringUtils.getNowTM());
        site.setSiteImg(fileUploadRsp.getImgUrl());
        site.setDes(des);
        site.setSiteName(siteName);
        site.setLoginAddr(loginAddr);
        site.setRegAddr(regAddr);
        site.setWId(Integer.parseInt(wId));
        siteService.insertSite(site);
        return rsp;
    }
}
