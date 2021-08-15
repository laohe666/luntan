package com.zl.luntan;

import com.zl.luntan.common.enums.ComEnums;
import com.zl.luntan.common.util.StringUtils;
import com.zl.luntan.dal.dao.TalkDao;
import com.zl.luntan.dal.entity.Talk;
import com.zl.luntan.dal.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.util.List;

@SpringBootTest
class LuntanApplicationTests {

    @Autowired
    private TalkDao talkDao;
    @Test
    void contextLoads() throws IOException {
//        String a = "555.5.txt";
//        String substring = a.substring(a.lastIndexOf("."));
//        System.out.println(substring);
//        File file1 = new File(ComEnums.FILE_PATH);
//        String absolutePath = file1.getAbsolutePath();
//        System.out.println(absolutePath);
//        String a= "高德充值高德无敌高德无敌高德无敌高德无敌高德无敌高德无敌高德无敌高德无敌高德无敌高德无敌 高德充值高德无敌高德无敌高德无敌高德无敌高德无敌高德无敌高德无敌高德无敌高德无敌高德无敌 高德充值高德无敌高德无敌高德无敌高德无敌高德无敌高德无敌高德无敌高德无敌高德无敌高德无敌 高德充值高德无敌高德无敌高德无敌高德无敌高德无敌高德无敌高德无敌高德无敌高德无敌高德无敌 高德充高德充值高德无敌高德无敌高德无敌高德无敌高德无敌高德无敌高德无敌高德无敌高德无敌高德无敌 高德充高德充值高德无敌高德无敌高德无敌高德无敌高德无敌高德无敌高德无敌高德无敌高德无敌高德无敌 高德充";
//        System.out.println(a.length());
//        Talk talk = new Talk();
//        User user = new User();
////        List<Talk> talk1 = talkDao.selecAllNTalk();
////        System.out.println(talk1);
//        user.setUId(1);
//        talk.setUser(user);
//        int i = talkDao.countByUser(talk);
//        System.out.println(i);
        System.out.println(System.getProperty("user.dir") + File.separator + "src" +File.separator + "main" + File.separator + "resources" + File.separator + "static" + File.separator);
        System.out.println("/**");
    }

}
