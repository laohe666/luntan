package com.zl.luntan.config;

import com.zl.luntan.common.enums.ComEnums;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/8/15 16:55
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Configuration
public class FileUploadConfig extends WebMvcConfigurationSupport {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        //获取文件的真实路径
        String path = System.getProperty("user.dir") + File.separator + "src" +File.separator + "main" + File.separator + "resources" + File.separator + "static" + File.separator;
        registry.addResourceHandler("/**").addResourceLocations("file:"+path);
    }

}
