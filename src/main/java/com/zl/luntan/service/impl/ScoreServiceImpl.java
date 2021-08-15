package com.zl.luntan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zl.luntan.dal.dao.ScoreDao;
import com.zl.luntan.dal.dto.ScoreRsp;
import com.zl.luntan.dal.entity.Score;
import com.zl.luntan.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/8/2 22:23
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreDao scoreDao;

    @Override
    public ScoreRsp selectAll(int pageNum, int pageSize) {
        ScoreRsp rsp = new ScoreRsp();
        PageHelper.startPage(pageNum,pageSize);
        List<Score> scores = scoreDao.selectAll();
        PageInfo<Score> pageInfo = new PageInfo<>(scores);
        rsp.setTotal(pageInfo.getTotal());
        rsp.setScores(pageInfo.getList());
        return rsp;
    }

    @Override
    public ScoreRsp selectNAll(int pageNum, int pageSize) {
        ScoreRsp rsp = new ScoreRsp();
        PageHelper.startPage(pageNum, pageSize);
        List<Score> scores = scoreDao.selectNAll();
        PageInfo<Score> pageInfo = new PageInfo<>(scores);
        rsp.setScores(pageInfo.getList());
        rsp.setTotal(pageInfo.getTotal());
        return rsp;
    }

    @Override
    public int insertScore(Score score) {
        return scoreDao.insertScore(score);
    }

    @Override
    public int delScore(Score score) {
        return scoreDao.delScore(score);
    }

    @Override
    public boolean upScore(Score score) {
        return scoreDao.upScore(score) > 0;
    }
}
