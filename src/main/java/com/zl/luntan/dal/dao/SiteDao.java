package com.zl.luntan.dal.dao;

import com.zl.luntan.dal.entity.Site;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/12 22:13
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Repository
public interface SiteDao {

    /**
     * 根据网站分类名查询未删除的网站
     * */
    List<Site> selectNSites(int wId);


    /**
     *  插入网站
     * */
    int insertSite(Site site);

    /**
     * 更新网站内容
     * */
    int updSite(Site site);

}
