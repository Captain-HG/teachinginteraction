package com.lzc.teachingInteraction.service.impl;

import com.lzc.teachingInteraction.entity.Teacher;
import com.lzc.teachingInteraction.mapper.TeacherMapper;
import com.lzc.teachingInteraction.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public Teacher selectById(String tId) {
        return teacherMapper.selectByPrimaryKey(tId);
    }
}
