package com.zl.luntan.service;

import com.zl.luntan.dal.dto.WebTypeRsp;
import com.zl.luntan.dal.entity.WebType;

import java.util.List;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/7/12 10:16
 * copyright @2021 北京沐融信息科技股份有限公司
 */

public interface WebTypeService {
    /**
     * 增加WebType对象
     * */
    boolean insertWebType(WebType webType);

    /**
     * 查询所有WebType
     * */
    WebTypeRsp selectAllWT(int pageNum, int pageSize);

    /**
     * 查询没有删除的WebType
     * */
    List<WebType> selectNAllWT();

    /**
     * 删除
     * */
    boolean updWTisDel(int wId, String isDel);
}
