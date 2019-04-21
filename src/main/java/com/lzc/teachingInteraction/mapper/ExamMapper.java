package com.lzc.teachingInteraction.mapper;

import com.lzc.teachingInteraction.entity.Exam;
import com.lzc.teachingInteraction.entity.ExamExample;
import com.lzc.teachingInteraction.utils.IBaseMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ExamMapper extends IBaseMapper<Exam> {
    /** 查询考试根据资料id*/
    Exam selectByMId(String mId);
    /** 查询考试，期末考试*/
    Exam selectByCIdAndType(String cId, byte examTypeLast);
    /** mysql的外连接进行查询*/
    List<Exam> selectAllByTId(String tId);
}