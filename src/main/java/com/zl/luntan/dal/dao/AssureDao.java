package com.zl.luntan.dal.dao;

import com.zl.luntan.dal.entity.Assure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssureDao {

    /**
     * 查询未删除的担保平台
     * */
    List<Assure> selectAllNAssure();
    /**
     * 删除担保平台
     * */
    int delAssure(Assure assure);
    /**
     * 增加担保平台
     * */
    int addAssure(Assure assure);
    /**
     * 修改担保平台
     * */
    int upAssure(Assure assure);




}
