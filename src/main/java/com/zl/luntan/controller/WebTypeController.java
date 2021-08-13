package com.zl.luntan.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zl.luntan.common.enums.ComEnums;
import com.zl.luntan.common.util.FileUpload;
import com.zl.luntan.common.util.StringUtils;
import com.zl.luntan.dal.dao.WebTypeDao;
import com.zl.luntan.dal.dto.FileUploadRsp;
import com.zl.luntan.dal.dto.WebTypeRsp;
import com.zl.luntan.dal.entity.WebType;
import com.zl.luntan.service.impl.WebTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @Autowired
    private WebTypeDao webTypeDao;
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

    /**
     * 展示所有的网站类型
     * */
    @ResponseBody
    @PostMapping("/showAllWT")
    public WebTypeRsp showAllWT(int pageNum, int pageSize){
        WebTypeRsp rsp = new WebTypeRsp();
        //查询所有
        try {
        rsp = webTypeService.selectAllWT(pageNum, pageSize);
        rsp.setMsg("查询成功");
        rsp.setState(ComEnums.STATE_Y);
        } catch (Exception e) {
            rsp.setState(ComEnums.STATE_N);
            rsp.setMsg("查询失败");
            return rsp;
        }
        return rsp;
    }

    /**
     * 修改类型状态
     * */
    @ResponseBody
    @PostMapping("/updateWTState")
    public WebTypeRsp updateWTState(int wId, String isDel){
        WebTypeRsp rsp = new WebTypeRsp();
       if (ComEnums.Y.equals(isDel)) {
           if (!webTypeService.updWTisDel(wId, ComEnums.N)){
               rsp.setMsg("修改状态失败");
               rsp.setState(ComEnums.STATE_N);
               return rsp;
           }
       } else {
           if (!webTypeService.updWTisDel(wId, ComEnums.Y)){
               rsp.setMsg("修改状态失败");
               rsp.setState(ComEnums.STATE_N);
               return rsp;
           }
       }
        rsp.setMsg("修改状态成功");
        rsp.setState(ComEnums.STATE_Y);
        return rsp;
    }

    /**
     * 修改网站类型信息
     * */
    @ResponseBody
    @PostMapping("/updateWebType")
    public WebTypeRsp updateWebType(@RequestBody WebType webType){
        WebTypeRsp rsp = new WebTypeRsp();
        webType.setUpTime(StringUtils.getNowTM());
        System.out.println(webType);
        System.out.println(webTypeDao.updWebType(webType));
        rsp.setState(ComEnums.STATE_Y);
        rsp.setMsg("更新成功");
        return rsp;
    }

    /**
     * 修改网站类型图片
     * */
    @ResponseBody
    @RequestMapping("/updateWTImg")
    public WebTypeRsp updateWTImg(@RequestParam("file") MultipartFile file, String wId){
        WebTypeRsp rsp = new WebTypeRsp();
        if (file.isEmpty()) {
            rsp.setMsg("上传文件为空");
            return rsp;
        }
        FileUploadRsp fileUploadRsp = FileUpload.uploadFile(file);
        if (fileUploadRsp.getState().equals(ComEnums.STATE_N)){
            rsp.setMsg("上传文件失败");
            return rsp;
        }
        WebType webType = new WebType();
        webType.setUpTime(StringUtils.getNowTM());
        webType.setWId(Integer.parseInt(wId));
        webType.setWebImg(fileUploadRsp.getImgUrl());
        webTypeDao.updateImg(webType);
        rsp.setMsg("上传成功！");
        return rsp;
    }

    /**
     * 添加网站
     * */
    @ResponseBody
    @PostMapping("/addWT")
    public WebTypeRsp addWT(@RequestParam("file") MultipartFile file, String des, String typeName){
        WebTypeRsp rsp = new WebTypeRsp();
        if(file.isEmpty()){
            rsp.setMsg("上传文件是空的");
            return rsp;
        }
        FileUploadRsp fileUploadRsp = FileUpload.uploadFile(file);
        WebType webType = new WebType();
        webType.setUpTime(StringUtils.getNowTM());
        webType.setWebImg(fileUploadRsp.getImgUrl());
        webType.setDes(des);
        webType.setTypeName(typeName);
        if (!webTypeService.insertWebType(webType)){
            rsp.setMsg("添加失败");
            return rsp;
        }
        rsp.setMsg("添加成功");
        return rsp;
    }

    /**
     * 搜索网站类型
     * */
    @ResponseBody
    @GetMapping("/seletType")
    public WebTypeRsp seletType(){
        WebTypeRsp rsp = new WebTypeRsp();
        List<WebType> webType = webTypeDao.selectNameAndId();
        rsp.setWebTypes(webType);
        rsp.setMsg("查询成功");
        return rsp;
    }
}
