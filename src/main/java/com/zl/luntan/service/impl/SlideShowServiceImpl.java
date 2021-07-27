package com.zl.luntan.service.impl;

import com.zl.luntan.dal.dao.SlideShowDao;
import com.zl.luntan.dal.entity.SlideShow;
import com.zl.luntan.service.SlideShowService;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/15 14:13
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Service
public class SlideShowServiceImpl implements SlideShowService {

    @Autowired
    private SlideShowDao slideShowDao;
    @Override
    @Transactional
    public List<SlideShow> selectAllNSlide() {
        return slideShowDao.selectAllNSlide();
    }

    @Override
    @Transactional
    public boolean insertSlide(SlideShow slideShow) {
        return slideShowDao.insertSlide(slideShow) > 0;
    }

    @Override
    @Transactional
    public boolean updateSlide(SlideShow slideShow) {
        return slideShowDao.updateSlide(slideShow) > 0;
    }
}
