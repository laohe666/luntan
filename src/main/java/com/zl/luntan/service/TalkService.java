package com.zl.luntan.service;

import com.zl.luntan.dal.dto.TalkRsp;
import com.zl.luntan.dal.entity.Talk;

import java.util.List;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/18 11:45
 * copyright @2021 北京沐融信息科技股份有限公司
 */
public interface TalkService {

    /**
     * 增加评论
     * */
    boolean insertTalk(Talk talk);

    /**
     * 展示评论
     * */
    TalkRsp selecAllNTalk(int pageNum, int pageSize);

    /**
     * 计算当前用户未审核的条数
     * */
    int countByUser(Talk talk);
}
