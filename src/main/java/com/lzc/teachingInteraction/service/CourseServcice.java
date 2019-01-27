package com.lzc.teachingInteraction.service;

import com.lzc.teachingInteraction.entity.Course;
import com.lzc.teachingInteraction.vo.CourseVo;

import java.util.List;

public interface CourseServcice {
    /** 根据主键查询*/
    Course selectById(String cId);
    /** 查询所有课程*/
    List<Course> selectAll();
    /** 查询所有课程vo*/
    List<CourseVo> selectAllVo();
}
