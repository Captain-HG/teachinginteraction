package com.lzc.teachingInteraction.service;

import com.lzc.teachingInteraction.entity.Course;
import com.lzc.teachingInteraction.entity.Teacher;

public interface TeacherService {
    /** 根据主键查询*/
    Teacher selectById(String tId);
}
