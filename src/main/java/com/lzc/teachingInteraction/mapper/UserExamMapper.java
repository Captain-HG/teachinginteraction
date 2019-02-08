package com.lzc.teachingInteraction.mapper;

import com.lzc.teachingInteraction.entity.UserExam;
import com.lzc.teachingInteraction.entity.UserExamExample;
import com.lzc.teachingInteraction.utils.IBaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserExamMapper extends IBaseMapper<UserExam> {
    int countByExample(UserExamExample example);

    int deleteByExample(UserExamExample example);

    List<UserExam> selectByExample(UserExamExample example);

    int updateByExampleSelective(@Param("record") UserExam record, @Param("example") UserExamExample example);

    int updateByExample(@Param("record") UserExam record, @Param("example") UserExamExample example);
}