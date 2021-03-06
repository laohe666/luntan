package com.zl.luntan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zl.luntan.dal.dao.UserDao;
import com.zl.luntan.dal.dto.UserRsp;
import com.zl.luntan.dal.entity.User;
import com.zl.luntan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/10 22:31
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public User selectUserById(int uId) {
        return userDao.selectUserById(uId);
    }

    @Override
    @Transactional
    public UserRsp selectAllUser(int pageNum, int pageSize) {
        UserRsp rsp = new UserRsp();
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userDao.selectAllUser();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        rsp.setUserList(pageInfo.getList());
        rsp.setTotal(pageInfo.getTotal());
        return rsp;
    }

    @Override
    @Transactional
    public User selectUsrByPsd(String email, String password) {
        return userDao.selectUsrByPsd(email, password);
    }

    @Override
    @Transactional
    public boolean insertUser(User user) {
        return userDao.insertUser(user) > 0;
    }

    @Override
    @Transactional
    public boolean updUsrIsDel(int uId, String isDel) {
        return userDao.updUsrIsDel(uId, isDel) > 0;
    }

    @Override
    @Transactional
    public boolean updateUser(User user) {
        return userDao.updateUser(user) > 0;
    }

    @Override
    @Transactional
    public boolean updUsrLgTm(User user) {
        return userDao.updUsrLgTm(user) > 0;
    }

    @Override
    public String selectUserEmail(String email) {
        return userDao.selectUserEmail(email);
    }
}
