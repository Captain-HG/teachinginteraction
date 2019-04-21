package com.lzc.teachingInteraction.service.impl;

import com.lzc.teachingInteraction.config.WebConst;
import com.lzc.teachingInteraction.entity.Student;
import com.lzc.teachingInteraction.entity.Teacher;
import com.lzc.teachingInteraction.mapper.StudentMapper;
import com.lzc.teachingInteraction.service.StudentService;
import com.lzc.teachingInteraction.service.TeacherService;
import com.lzc.teachingInteraction.utils.UUID;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    TeacherService teacherService;
    @Override
    public void add(String getuId, String schoolName, String grade) {
        Student student = new Student();
        student.setsId(UUID.UU32());
        student.setuId(getuId);
        student.setSchoolName(schoolName);
        if (StringUtils.isNotBlank(grade)) {
            student.setsGrade(grade);
        }
        else
        {
            student.setsGrade(null);
        }
        student.setState(WebConst.USER_STATE_YESUSE);
        studentMapper.insert(student);
    }

    @Override
    public Student selectByUId(String getuId) {
        return studentMapper.selectByUId(getuId);
    }

    @Override
    @Transactional
    public void checkAndUpdate(String getuId, String schoolName, String grade) {
        Student student = studentMapper.selectByUId(getuId);
        System.out.println("stu:"+getuId);
        Teacher teacher = teacherService.selectByUId(getuId);
        if (teacher!=null){
            //说明之前可能注册成为老师，此时我们改变他的状态为noUse
            teacherService.changeState(teacher.gettId(),WebConst.USER_STATE_NOUSE);
        }
        if (student!=null){//说明之前存在过该学生
            student.setSchoolName(schoolName);
            student.setState(WebConst.USER_STATE_YESUSE);
            student.setsGrade(grade);
            studentMapper.updateByPrimaryKeySelective(student);
        }else{
            add(getuId,schoolName,grade);
        }

    }

    @Override
    public void changeState(String sId, byte state) {
        System.out.println("stu:"+state);
        Student student = studentMapper.selectByPrimaryKey(sId);
        student.setState(state);
        studentMapper.updateByPrimaryKeySelective(student);
    }
}
