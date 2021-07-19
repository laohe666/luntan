package com.zl.luntan.common.util;

import com.zl.luntan.common.enums.ComEnums;
import com.zl.luntan.dal.dto.FileUploadRsp;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/13 20:39
 * copyright @2021 北京沐融信息科技股份有限公司
 */
public class FileUpload {
    //文件上传工具
    public static FileUploadRsp uploadFile(MultipartFile file){


        FileUploadRsp rsp = new FileUploadRsp();
        //判断文件是否为空
        if(file.isEmpty()){
            rsp.setMsg("上传文件为空");
            rsp.setState(ComEnums.STATE_N);
            return rsp;
        }
        //文件上传
        //真实文件名
        String rlFileName = file.getOriginalFilename();
        //获取文件名后缀
        String fileForMat = rlFileName.substring(rlFileName.lastIndexOf("."));
        //如果不是文件格式
        if(!ComEnums.IMG_JGP.equals(fileForMat) && !ComEnums.IMG_PNG.equals(fileForMat)){
            rsp.setState(ComEnums.STATE_N);
            rsp.setMsg("图片只能上传png或jpg格式");
            return rsp;
        }
        //如果文件格式正确 拼接文件上传路径 完整的文件名
        File file1 = new File(ComEnums.FILE_PATH);
        String absolutePath = file1.getAbsolutePath();
        String uuid = StringUtils.getUUID();
        String rlPath = absolutePath + File.separator + uuid + fileForMat;
        File file2 = new File(rlPath);
        //查询是否存在文件
        if(file2.exists()){
            rsp.setMsg("图片已经存在,请重新上传");
            rsp.setState(ComEnums.STATE_N);
            return rsp;
        }
        //然后上传到路径
        try {
            file.transferTo(file2);
        } catch (IOException e) {
            rsp.setMsg("文件上传时失败");
            rsp.setState(ComEnums.STATE_N);
            return rsp;
        }
        rsp.setImgUrl("http://localhost:8080/" + uuid + fileForMat);
        rsp.setMsg("文件上传成功");
        rsp.setState(ComEnums.STATE_Y);
        return rsp;

    }
}
