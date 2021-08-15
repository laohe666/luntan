package com.zl.luntan.controller;

import com.zl.luntan.common.enums.ComEnums;
import com.zl.luntan.common.util.JwtUtils;
import com.zl.luntan.common.util.StringUtils;
import com.zl.luntan.dal.dao.TalkDao;
import com.zl.luntan.dal.dto.TalkRsp;
import com.zl.luntan.dal.entity.Talk;
import com.zl.luntan.dal.entity.User;
import com.zl.luntan.service.impl.TalkServiceImpl;
import jdk.nashorn.internal.parser.Token;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/18 11:50
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Controller
public class TalkController {
    @Autowired
    private TalkServiceImpl talkService;

    @Autowired
    private TalkDao talkDao;
    /**
     * 发布Talk
     * */
    @ResponseBody
    @PostMapping("/sdTalk")
    public TalkRsp sendTalk(String context,String token){
        TalkRsp rsp = new TalkRsp();
        //先验证是否登陆
        boolean flag = JwtUtils.verifyToken(token);
        if(flag){
            Talk talk = new Talk();
            talk.setContext(context);
            // 如果验证生效 创建token对象 插入评论
            User user = new User();
            user.setUId(Integer.parseInt(JwtUtils.getAudience(token)));
            talk.setUser(user);
            //然后搜索数据库中的记录条数
            int i = talkService.countByUser(talk);
            if(i >= ComEnums.THREE){
                rsp.setMsg("您有三条记录未审核,请联系管理员处理再发布");
                rsp.setState(ComEnums.STATE_N);
                return rsp;
            }
            talk.setSendTime(StringUtils.getNowTM());
            talk.setUpTime(StringUtils.getNowTM());
            try {
                if(talkService.insertTalk(talk)){
                    rsp.setMsg("发布成功,请联系管理员通过审核查看哦");
                    rsp.setState(ComEnums.STATE_Y);
                } else {
                    rsp.setMsg("发布失败");
                    rsp.setState(ComEnums.STATE_N);
                    return rsp;
                }
            } catch (Exception e) {
                rsp.setMsg("发布失败");
                rsp.setState(ComEnums.STATE_N);
                return rsp;
            }
        } else {
            rsp.setMsg("您没登陆,请登陆后发布!");
            rsp.setState(ComEnums.STATE_N);
            return rsp;
        }
        return rsp;
    }

    /**
     * 展示所有未删除的Talk
     * */
    @ResponseBody
    @PostMapping("/showAllNTalk")
    public TalkRsp showAllNTalks(int pageNum, int pageSize){
        TalkRsp rsp = new TalkRsp();
        try {
            rsp = talkService.selecAllNTalk(pageNum, pageSize);
            rsp.setMsg("查询成功");
            rsp.setState(ComEnums.STATE_Y);
            rsp.setTalks(rsp.getTalks());
        } catch (Exception e) {
            rsp.setMsg("查询错误");
            rsp.setState(ComEnums.STATE_N);
            return rsp;
        }
        return rsp;
    }


    /**
     * 搜素所有的talk
     * */
    @ResponseBody
    @PostMapping("/selectAllTalk")
    public TalkRsp selectAllTalk(int pageNum, int pageSize){
        TalkRsp rsp = talkService.selectAllTalk(pageNum, pageSize);
        rsp.setMsg("查询成功");
        return rsp;
    }

    /**
     * 更新talk
     * */
    @ResponseBody
    @PostMapping("/updateTalk")
    public TalkRsp updateTalk(@RequestBody Talk talk){
        TalkRsp rsp = new TalkRsp();
        if(talk != null) {
            talk.setUpTime(StringUtils.getNowTM());
            if(talkDao.updateTalk(talk) < 0){
                rsp.setMsg("更新失败");
                return rsp;
            }
        }
        rsp.setMsg("更新成功");
        return rsp;
    }
}
