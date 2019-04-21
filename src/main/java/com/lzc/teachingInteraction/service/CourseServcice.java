package com.lzc.teachingInteraction.service;

import com.lzc.teachingInteraction.entity.Course;
import com.lzc.teachingInteraction.vo.CourseVo;

import java.util.HashMap;
import java.util.List;

public interface CourseServcice {
    /** 根据主键查询*/
    Course selectById(String cId);
    /** 查询所有课程*/
    List<Course> selectAll();
    /** 查询所有课程vo*/
    List<CourseVo> selectAllVo();
    /** 更新课程*/
    void update(Course course);
    /** 根据id删除课程*/
    void del(String cId);
    /** 根据老师id查询课程*/
    List<Course> selectBytId(String gettId);
    /** 启用该课程*/
    void start(String getcId);
    /** 禁用*/
    void stop(String cId);
    /** 查询所有状态可用的课程*/
    List<Course> selectAllByStateYes();
    /** 根据老师id查看它的课程*/
    List<CourseVo> selectAllVoByTId(String tId);
    /** 增加课程*/
    void add(Course course);
    /** 使课程收藏数加1*/
    void addChange(String cId);
    /** 使课程收藏数减1*/
    void delChange(String cId);

}
