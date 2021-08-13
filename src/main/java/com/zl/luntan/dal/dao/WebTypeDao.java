package com.zl.luntan.dal.dao;

import com.zl.luntan.dal.entity.WebType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/12 9:37
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Repository
public interface WebTypeDao {

    /**
     * 增加WebType对象
     * */
    int insertWebType(WebType webType);

    /**
     * 查询所有WebType
     * */
    List<WebType> selectAllWT();

    /**
     * 查询没有删除的WebType
     * */
    List<WebType> selectNAllWT();

    /**
     * 删除
     * */
    int updWTisDel(int wId, String isDel);

    /**
     * 修改webType
     * */
    int updWebType(WebType webType);

    /**
     * 修改网站类型图片
     * */
    int updateImg(WebType webType);

    /**
     * 搜索网站类型和名称
     * */
    List<WebType> selectNameAndId();
}
