package com.lzc.teachingInteraction.service.impl;

import com.lzc.teachingInteraction.config.WebConst;
import com.lzc.teachingInteraction.entity.*;
import com.lzc.teachingInteraction.entity.Teacher;
import com.lzc.teachingInteraction.mapper.TeacherMapper;
import com.lzc.teachingInteraction.service.CourseServcice;
import com.lzc.teachingInteraction.service.StudentService;
import com.lzc.teachingInteraction.service.TeacherService;
import com.lzc.teachingInteraction.utils.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    StudentService studentService;
    @Autowired
    CourseServcice courseServcice;
    @Override
    public Teacher selectById(String tId) {
        return teacherMapper.selectByPrimaryKey(tId);
    }

    @Override
    public void add(String getuId,String schoolName) {
        Teacher teacher = new Teacher();
        teacher.settId(UUID.UU32());
        teacher.setuId(getuId);
        teacher.setSchoolName(schoolName);
        teacherMapper.insert(teacher);
    }

    @Override
    public Teacher selectByUId(String getuId) {
        return teacherMapper.selectByUId(getuId);
    }

    @Override
    @Transactional
    public void changeState(String gettId, byte state) {
        System.out.println("tea:"+state);
        Teacher teacher = teacherMapper.selectByPrimaryKey(gettId);
        List<Course> courseList = courseServcice.selectBytId(gettId);
        for(Course course:courseList){
            if (state==WebConst.USER_STATE_YESUSE){
            courseServcice.start(course.getcId());
            }else {
             courseServcice.stop(course.getcId());
            }
        }
        teacher.setState(state);
        teacherMapper.updateByPrimaryKeySelective(teacher);
    }

    @Override
    @Transactional
    public void checkAndUpdate(String getuId, String schoolName) {
        Teacher teacher = teacherMapper.selectByUId(getuId);
        Student student = studentService.selectByUId(getuId);
        if (student!=null){//说明之前有过该学生字段
            studentService.changeState(student.getsId(),WebConst.USER_STATE_NOUSE);
        }
        if (teacher!=null){//说明之前存在过该老师
            teacher.setSchoolName(schoolName);
            teacher.setState(WebConst.USER_STATE_YESUSE);
            teacherMapper.updateByPrimaryKeySelective(teacher);
        }
    }

    @Override
    public boolean isExtis(String getuId) {
        Teacher teacher = teacherMapper.selectByUId(getuId);
        if (teacher!=null){
            return true;
        }else {
            return false;
        }
    }
}
