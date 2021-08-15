package com.zl.luntan.controller;

import com.zl.luntan.common.enums.ComEnums;
import com.zl.luntan.common.util.FileUpload;
import com.zl.luntan.common.util.StringUtils;
import com.zl.luntan.dal.dto.AssureRsp;
import com.zl.luntan.dal.dto.FileUploadRsp;
import com.zl.luntan.dal.entity.Assure;
import com.zl.luntan.service.impl.AssureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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


    /**
     * 添加担保网站
     * */
    @ResponseBody
    @PostMapping("/addAssure")
    public AssureRsp addAssure(@RequestParam("file") MultipartFile file, String name, String regAddr, String loginAddr, String des){
        AssureRsp rsp = new AssureRsp();
        if (file.isEmpty()){
            rsp.setMsg("图片为空");
            return rsp;
        }
        FileUploadRsp fileUploadRsp = FileUpload.uploadFile(file);
        Assure assure = new Assure();
        assure.setImgUrl(fileUploadRsp.getImgUrl());
        assure.setName(name);
        assure.setRegAddr(regAddr);
        assure.setLoginAddr(loginAddr);
        assure.setDes(des);
        assure.setUpTime(StringUtils.getNowTM());
        assureService.addAssure(assure);
        return rsp;
    }

}
