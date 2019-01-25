package com.lzc.teachingInteraction.service;

import com.lzc.teachingInteraction.entity.Course;

public interface CourseServcice {
    /** 根据主键查询*/
    Course selectById(String cId);
}
