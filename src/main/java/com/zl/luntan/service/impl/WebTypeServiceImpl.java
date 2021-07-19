package com.zl.luntan.service.impl;

import com.zl.luntan.dal.dao.WebTypeDao;
import com.zl.luntan.dal.entity.WebType;
import com.zl.luntan.service.WebTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/12 10:17
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Service
public class WebTypeServiceImpl implements WebTypeService {
    @Autowired
    private WebTypeDao webTypeDao;

    @Override
    @Transactional
    public boolean insertWebType(WebType webType) {
        return webTypeDao.insertWebType(webType) > 0;
    }

    @Override
    @Transactional
    public List<WebType> selectAllWT() {
        return webTypeDao.selectAllWT();
    }

    @Override
    @Transactional
    public List<WebType> selectNAllWT() {
        return webTypeDao.selectNAllWT();
    }

    @Override
    @Transactional
    public boolean updWTisDel(int wId) {
        return webTypeDao.updWTisDel(wId) > 0;
    }
}
