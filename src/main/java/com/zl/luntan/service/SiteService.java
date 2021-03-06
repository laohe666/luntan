package com.zl.luntan.service;

import com.zl.luntan.dal.entity.Site;

import java.util.List;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/13 18:18
 * copyright @2021 北京沐融信息科技股份有限公司
 */
public interface SiteService {

    /**
     * 根据网站分类名查询未删除的网站
     * */
    List<Site> selectNSites(int wId);


    /**
     *  插入网站
     * */
    boolean insertSite(Site site);

    /**
     * 更新网站内容
     * */
    boolean updSite(Site site);
}
