package com.zl.luntan.controller;

import com.zl.luntan.common.enums.ComEnums;
import com.zl.luntan.common.util.FileUpload;
import com.zl.luntan.common.util.JwtUtils;
import com.zl.luntan.common.util.StringUtils;
import com.zl.luntan.dal.dto.FileUploadRsp;
import com.zl.luntan.dal.dto.UserRsp;
import com.zl.luntan.dal.entity.User;
import com.zl.luntan.service.impl.UserServiceImpl;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.print.DocFlavor;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/10 22:41
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    /**
     * 登陆用户
     * */
    @ResponseBody
    @PostMapping("/login")
    public UserRsp loginUser(@RequestBody User user, HttpServletRequest request){
        System.out.println(request.getRemoteAddr());
        UserRsp rsp = new UserRsp();
        User sqUser;
        //通过用户对象查询对象
        try {
            sqUser = userService.selectUsrByPsd(user.getEmail(), user.getPassword());
        } catch (Exception e){
             rsp.setMsg("查询错误");
             rsp.setState(ComEnums.STATE_N);
             return rsp;
        }
        //如果查询用户不为空 将用户通过JWT加密
        String token = null;
        if(sqUser != null){
            token = JwtUtils.creatJwt(sqUser);
             //更改用户登陆时间
            sqUser.setLoginTime(StringUtils.getNowTM());
            try {
                userService.updUsrLgTm(sqUser);
            } catch (Exception e) {
                rsp.setMsg("更新状态失败");
                rsp.setState(ComEnums.STATE_N);
                return rsp;
            }
        }
        //返回加密后的user对象token
        rsp.setToken(token);
        rsp.setState(ComEnums.STATE_Y);
        return rsp;
    }

    /**
     *  注册用户
     * */
    @ResponseBody
    @PostMapping("/reg")
    public UserRsp regUser(@RequestBody User user){
        UserRsp rsp = new UserRsp();
        //先查询邮箱是否存在
        String email = userService.selectUserEmail(user.getEmail());
        //注册状态
        boolean flag = false;
        //如果邮箱不存在 注册
        if(email == null){
            user.setRegTime(StringUtils.getNowTM());
            user.setUpTime(StringUtils.getNowTM());
            try {
                flag = userService.insertUser(user);
                if(flag){
                    rsp.setState(ComEnums.STATE_Y);
                    rsp.setMsg("注册成功");
                }
            }catch (Exception e){
                rsp.setMsg("注册失败");
                rsp.setState(ComEnums.STATE_N);
                return rsp;
            }
        } else {
          rsp.setMsg("邮箱已存在");
          rsp.setState(ComEnums.STATE_N);
        }
        return rsp;
    }

    /**
     * 检验是否登陆
     **/
    @ResponseBody
    @PostMapping("/isLogin")
    public UserRsp isLogin(String token){
        UserRsp rsp = new UserRsp();
        //检验是否失效
        boolean flag = JwtUtils.verifyToken(token);
        System.out.println(flag);
        if(flag){
            rsp.setState(ComEnums.STATE_Y);
            rsp.setMsg("你已经登陆");
        }else {
            rsp.setState(ComEnums.STATE_N);
            rsp.setMsg("您没有登陆哦,请登陆您的账号享受更多功能！");
        }
        return rsp;
    }

    /**
     * 更新用户个人信息
     * */
    @ResponseBody
    @PostMapping("/upInfo")
    public UserRsp upInfo(String newPsd, String token, String oldPsd, String nickname, MultipartFile file){
        UserRsp rsp = new UserRsp();
        // 先验证用户是否登陆
        boolean flag = JwtUtils.verifyToken(token);
        if(flag){
            //获取用户邮箱
//            userService.selectUsrByPsd();
            //先检查用户旧密码是否正确
//            userService.selectUsrByPsd();

        }
        //

        return rsp;
    }

    /**
     * 修改用户头像
     **/
    @ResponseBody
    @RequestMapping("/upUsrHead")
    public UserRsp upUsrHead(@RequestParam("file") MultipartFile file, String token){
        UserRsp rsp = new UserRsp();
        //先验证用户是否登陆
        boolean flag = JwtUtils.verifyToken(token);
        //如果登陆成功
        if (flag) {
            //将头像上传到服务器
            FileUploadRsp fileUploadRsp = FileUpload.uploadFile(file);
            if (!ComEnums.STATE_Y.equals(fileUploadRsp.getState())) {
                rsp.setState(ComEnums.STATE_N);
                rsp.setMsg("False");
                return rsp;
            }
            //头像上传成功的话 新建对象
            User user = new User();
            user.setUId(Integer.parseInt(JwtUtils.getAudience(token)));
            user.setUpTime(StringUtils.getNowTM());
            user.setHeadPhoto(fileUploadRsp.getImgUrl());
            boolean upUsrFlg = userService.updateUser(user);
            // 如果更新失败
            if (!upUsrFlg) {
                rsp.setState(ComEnums.STATE_N);
                rsp.setMsg("False");
                return rsp;
            }
        }
            rsp.setMsg("修改头像成功");
            rsp.setState(ComEnums.STATE_Y);
            return rsp;
    }


}
