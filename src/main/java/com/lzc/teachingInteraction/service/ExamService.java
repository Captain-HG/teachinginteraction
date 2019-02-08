package com.lzc.teachingInteraction.service;

import com.lzc.teachingInteraction.entity.Exam;

import java.util.List;

public interface ExamService {
    /** 评分*/
    int scoreEqual(List<Integer> list, String eId);
    /** 根据资料查询*/
    Exam selectByMId(String mId);
    /** 根据课程id和类型查询*/
    Exam selectByCIdAndType(String cId, Integer examTypeLast);
}
