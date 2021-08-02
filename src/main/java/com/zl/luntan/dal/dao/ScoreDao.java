package com.zl.luntan.dal.dao;

import com.zl.luntan.dal.entity.Score;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreDao {

    /**
     * 查询全部黑分
     * */
    List<Score> selectAll();
    /**
     * 查询未删除的黑分
     * */
    List<Score> selectNAll();
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
