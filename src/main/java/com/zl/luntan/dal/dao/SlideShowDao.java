package com.zl.luntan.dal.dao;

import com.zl.luntan.dal.entity.SlideShow;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/14 18:48
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Repository
public interface SlideShowDao {

    /**
     * 查询未删除的轮播图列表
     * */
    List<SlideShow> selectAllNSlide();

    /**
     * 增加轮播图
     * */
    int insertSlide(SlideShow slideShow);

    /**
     * 修改轮播图
     * */
    int updateSlide(SlideShow slideShow);
}
