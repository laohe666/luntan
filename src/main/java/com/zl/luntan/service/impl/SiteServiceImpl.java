package com.zl.luntan.service.impl;

import com.zl.luntan.dal.dao.SiteDao;
import com.zl.luntan.dal.entity.Site;
import com.zl.luntan.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/13 18:19
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Service
public class SiteServiceImpl implements SiteService {

    @Autowired
    private SiteDao siteDao;


    @Override
    @Transactional
    public List<Site> selectNSites(int wId) {
        return siteDao.selectNSites(wId);
    }

    @Override
    @Transactional
    public boolean insertSite(Site site) {
        return siteDao.insertSite(site) > 0;
    }

    @Override
    @Transactional
    public boolean updSite(Site site) {
        return siteDao.updSite(site) > 0;
    }
}
