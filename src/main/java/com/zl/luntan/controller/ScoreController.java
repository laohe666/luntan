package com.zl.luntan.controller;

import com.zl.luntan.common.enums.ComEnums;
import com.zl.luntan.common.util.FileUpload;
import com.zl.luntan.common.util.StringUtils;
import com.zl.luntan.dal.dto.FileUploadRsp;
import com.zl.luntan.dal.dto.ScoreRsp;
import com.zl.luntan.dal.entity.Score;
import com.zl.luntan.service.impl.ScoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    /**
     * 展示所有黑分
     * */
    @ResponseBody
    @RequestMapping("/showAllScore")
    public ScoreRsp showAllScore(int pageNum, int pageSize){
        ScoreRsp rsp = scoreService.selectAll(pageNum, pageSize);
        rsp.setMsg("查询成功");
        return rsp;
    }

    /**
     * 更新图片
     * */
    @ResponseBody
    @PostMapping("/upScoreImg")
    public ScoreRsp upScoreImg(@RequestParam("file") MultipartFile file, String scId){
        ScoreRsp rsp = new ScoreRsp();
        if(file.isEmpty()){
            rsp.setMsg("文件为空");
            return rsp;
        }
        FileUploadRsp fileUploadRsp = FileUpload.uploadFile(file);
        if(ComEnums.STATE_N.equals(fileUploadRsp.getState())){
            rsp.setMsg("上传失败");
            return rsp;
        }
        Score score = new Score();
        score.setUpTime(StringUtils.getNowTM());
        score.setScId(Integer.parseInt(scId));
        score.setScoreImg(fileUploadRsp.getImgUrl());
        scoreService.upScore(score);
        rsp.setMsg("更新图片成功");
        return rsp;
    }

    /**
     * 更改数据
     * */
    @ResponseBody
    @PostMapping("/upScore")
    public ScoreRsp upScore(@RequestBody Score score){
        ScoreRsp rsp = new ScoreRsp();
        if(score == null){
            rsp.setMsg("为空");
            return rsp;
        }
        score.setUpTime(StringUtils.getNowTM());
        if(!scoreService.upScore(score)){
            rsp.setMsg("更新失败");
            return rsp;
        }
        rsp.setMsg("更新成功");
        return rsp;
    }


    /**
     * 添加黑分
     * */
    @ResponseBody
    @PostMapping("/addScore")
    public ScoreRsp addScore(@RequestParam("file") MultipartFile file, String des, String addr, String state, String name, String title){
        ScoreRsp rsp = new ScoreRsp();
        if (file.isEmpty()){
            rsp.setMsg("文件为空");
            return rsp;
        }
        FileUploadRsp fileUploadRsp = FileUpload.uploadFile(file);
        Score score = new Score();
        score.setDes(des);
        score.setAddr(addr);
        score.setState(state);
        score.setName(name);
        score.setTitle(title);
        score.setUpTime(StringUtils.getNowTM());
        score.setScoreImg(fileUploadRsp.getImgUrl());
        if(scoreService.insertScore(score) != 1){
            rsp.setMsg("添加失败");
            return rsp;
        };
        rsp.setMsg("添加成功");
        return rsp;
    }
}
