package com.zl.luntan.dal.dto;

import com.alibaba.fastjson.JSON;
import com.zl.luntan.dal.entity.Score;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Sun Jingchun
 * @version 5.0.0
 * created at 2021/8/2 22:27
 * copyright @2021 北京沐融信息科技股份有限公司
 */
@Data
public class ScoreRsp implements Serializable {

    private String msg;

    private String state;

    private List<Score> scores;

    private Score score;

    private Long total;

    @Override
    public String toString(){
        return JSON.toJSONString(this);    }
}
