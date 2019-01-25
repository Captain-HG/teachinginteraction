package com.lzc.teachingInteraction.service.impl;

import com.lzc.teachingInteraction.entity.Course;
import com.lzc.teachingInteraction.mapper.CourseMapper;
import com.lzc.teachingInteraction.service.CourseServcice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseServcice {
    @Autowired
    CourseMapper courseMapper;

    @Override
    public Course selectById(String cId) {
        return courseMapper.selectByPrimaryKey(cId);
    }
}
