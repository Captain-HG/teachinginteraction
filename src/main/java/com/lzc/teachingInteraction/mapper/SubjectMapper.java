package com.lzc.teachingInteraction.mapper;

import com.lzc.teachingInteraction.entity.Subject;
import com.lzc.teachingInteraction.entity.SubjectExample;
import com.lzc.teachingInteraction.utils.IBaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubjectMapper extends IBaseMapper<Subject> {
    /** 根据考试id查询题目*/
    List<Subject> selectALLByEId(String eId);
}