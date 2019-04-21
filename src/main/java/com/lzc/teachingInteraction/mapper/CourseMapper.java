package com.lzc.teachingInteraction.mapper;

import com.lzc.teachingInteraction.entity.Course;
import com.lzc.teachingInteraction.entity.CourseExample;
import com.lzc.teachingInteraction.utils.IBaseMapper;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseMapper extends IBaseMapper<Course> {
    /** 根据老师id查询课程*/
    List<Course> selectBytId(String tId);
    /** 查询状态好的课程*/
    List<Course> selectAllByStateYes();
    /** 根据老师id查询课程列表*/
    List<Course> selectAllByTId(String tId);
}