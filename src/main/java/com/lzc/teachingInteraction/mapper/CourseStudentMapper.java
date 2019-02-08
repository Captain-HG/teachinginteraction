package com.lzc.teachingInteraction.mapper;

import com.lzc.teachingInteraction.entity.CourseStudent;
import com.lzc.teachingInteraction.entity.CourseStudentExample;
import com.lzc.teachingInteraction.utils.IBaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseStudentMapper extends IBaseMapper<CourseStudent> {
    int countByExample(CourseStudentExample example);

    int deleteByExample(CourseStudentExample example);

    List<CourseStudent> selectByExample(CourseStudentExample example);

    int updateByExampleSelective(@Param("record") CourseStudent record, @Param("example") CourseStudentExample example);

    int updateByExample(@Param("record") CourseStudent record, @Param("example") CourseStudentExample example);
}