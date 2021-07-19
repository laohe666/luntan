package com.zl.luntan.service;

import com.zl.luntan.dal.entity.SlideShow;

import java.util.List;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/15 14:12
 * copyright @2021 北京沐融信息科技股份有限公司
 */
public interface SlideShowService {
    /**
     * 查询未删除的轮播图列表
     * */
    List<SlideShow> selectAllNSlide();

    /**
     * 增加轮播图
     * */
    boolean insertSlide(SlideShow slideShow);

    /**
     * 修改轮播图
     * */
    boolean updateSlide(SlideShow slideShow);
}
