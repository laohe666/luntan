package com.zl.luntan.service.impl;

import com.zl.luntan.dal.dao.AssureDao;
import com.zl.luntan.dal.entity.Assure;
import com.zl.luntan.service.AssureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/8/3 14:49
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Service
public class AssureServiceImpl implements AssureService {

    @Autowired
    private AssureDao assureDao;

    @Override
    public List<Assure> selectAllNAssure() {
        return assureDao.selectAllNAssure();
    }

    @Override
    public int delAssure(Assure assure) {
        return assureDao.delAssure(assure);
    }

    @Override
    public int addAssure(Assure assure) {
        return assureDao.addAssure(assure);
    }

    @Override
    public int upAssure(Assure assure) {
        return assureDao.upAssure(assure);
    }
}
