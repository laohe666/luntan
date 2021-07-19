package com.zl.luntan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zl.luntan.dal.dao.TalkDao;
import com.zl.luntan.dal.dto.TalkRsp;
import com.zl.luntan.dal.entity.Talk;
import com.zl.luntan.service.TalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/18 11:46
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Service
public class TalkServiceImpl implements TalkService {

    @Autowired
    private TalkDao talkDao;

    @Override
    @Transactional
    public boolean insertTalk(Talk talk) {
        return talkDao.insertTalk(talk) > 0;
    }

    @Override
    @Transactional
    public TalkRsp selecAllNTalk(int pageNum, int pageSize) {
        TalkRsp rsp = new TalkRsp();
        PageHelper.startPage(pageNum, pageSize);
        List<Talk> talks = talkDao.selecAllNTalk();
        System.out.println(talks.toString());
        PageInfo<Talk> pageInfo = new PageInfo<>(talks);
        rsp.setTalks(pageInfo.getList());
        rsp.setTotal(pageInfo.getTotal());
        return rsp;
    }

    @Override
    @Transactional
    public int countByUser(Talk talk) {
        return talkDao.countByUser(talk);
    }
}
