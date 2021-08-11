package com.zl.luntan.dal.dao;

import com.zl.luntan.dal.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/9 18:47
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Repository
public interface UserDao {
    /**
     * 搜索用户信息
     * */
    User selectUserById(int uId);

    /**
     * 搜索用户列表
     * */
    List<User> selectAllUser();

    /**
     * 通过邮箱和密码搜索用户
     * */
    User selectUsrByPsd(String email, String password);

    /**
     * 插入用户
     * */
    int insertUser(User user);

    /**
     * 修改用户id_del字段
     * */
    int updUsrIsDel(int uId, String isDel);

    /**
     * 修改用户信息
     * */
    int updateUser(User user);

    /**
     * 更新用户登陆时间
     * */
    int updUsrLgTm(User user);

    /**
     * 通过邮箱搜素用户邮箱是否存在
     * */
    String selectUserEmail(String email);
}
