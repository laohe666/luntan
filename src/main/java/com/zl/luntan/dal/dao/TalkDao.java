package com.zl.luntan.dal.dao;

import com.zl.luntan.dal.entity.Talk;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/15 17:00
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Repository
public interface TalkDao {
    /**
     * 增加评论
     * */
    int insertTalk(Talk talk);

    /**
     * 展示评论
     * */
    List<Talk> selecAllNTalk();

    /**
     * 计算当前用户未审核的条数
     * */
    int countByUser(Talk talk);

    /**
     * 搜索Talk
     * */
    List<Talk> selectAllTalk();

    /**
     * 更新Talk
     * */
    int updateTalk(Talk talk);
}
