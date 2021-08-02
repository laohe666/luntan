package com.zl.luntan.service;

import com.zl.luntan.dal.dto.ScoreRsp;
import com.zl.luntan.dal.entity.Score;

import java.util.List;

public interface ScoreService {
    /**
     * 查询全部黑分
     * */
    List<Score> selectAll();
    /**
     * 查询未删除的黑分
     * */
    ScoreRsp selectNAll(int pageNum, int pageSize);
    /**
     * 插入黑分
     * */
    int insertScore(Score score);
    /**
     * 删除黑分
     * */
    int delScore(Score score);
    /**
     * 修改黑分
     * */
    int upScore(Score score);
}
