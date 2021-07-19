package com.zl.luntan.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/9 16:46
 * copyright @2021 北京沐融信息科技股份有限公司
 */
public class StringUtils {

    /**
     *  返回当前时间
     * */
    public static String getNowTM(){
        return new SimpleDateFormat("yyyy-MM-dd HH:MM:SS").format(new Date());
    }

    /**
     *  返回当前日期
     * */
    public static String getNowDT(){
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    /**
     * 获取uuid
     * */
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        return uuid.replace("-","");
    }
}
