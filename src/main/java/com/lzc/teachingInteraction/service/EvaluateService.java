package com.lzc.teachingInteraction.service;

import com.lzc.teachingInteraction.entity.Evaluate;
import com.lzc.teachingInteraction.vo.EvaluateCourseVo;

import java.util.List;

public interface EvaluateService {
     /** 根据课程id，查询所有的评价*/
    List<Evaluate> selectAllByCId(String cId);
    /** 根据课程id，查询封装好的评价*/
    List<EvaluateCourseVo> selectECVoByCId(String cId);
}
