package com.lzc.teachingInteraction.service;

import com.lzc.teachingInteraction.entity.Exam;
import com.lzc.teachingInteraction.vo.ExamVo;

import java.util.List;

public interface ExamService {
    /** 评分,返回*/
    List<Integer> scoreEqual(List<Integer> list, String eId);
    /** 根据资料查询*/
    Exam selectByMId(String mId);
    /** 根据课程id和类型查询*/
    Exam selectByCIdAndType(String cId, byte examTypeLast);
    /** */
    List<ExamVo> selectAllVo();
    /** 根据主键查询*/
    Exam selectById(String eId);
    /** 更新*/
    void update(Exam exam);
    /** 删除*/
    void del(String eId);
    /** 增加*/
    void add(Exam exam);
    /** 根据老师id查询考试*/
    List<ExamVo> selectAllVoByTId(String tId);
}
