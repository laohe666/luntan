package com.zl.luntan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zl.luntan.dal.dao")
public class LuntanApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuntanApplication.class, args);
    }

}
