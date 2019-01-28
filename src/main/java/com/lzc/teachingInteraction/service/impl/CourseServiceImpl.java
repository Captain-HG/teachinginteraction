package com.lzc.teachingInteraction.service.impl;

import com.lzc.teachingInteraction.entity.Course;
import com.lzc.teachingInteraction.mapper.CourseMapper;
import com.lzc.teachingInteraction.service.CourseServcice;
import com.lzc.teachingInteraction.service.TeacherService;
import com.lzc.teachingInteraction.service.UserService;
import com.lzc.teachingInteraction.vo.CourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseServcice {
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    TeacherService teacherService;
    @Autowired
    UserService userService;

    @Override
    public Course selectById(String cId) {
        return courseMapper.selectByPrimaryKey(cId);
    }

    @Override
    public List<Course> selectAll() {
        return courseMapper.selectAll();
    }

    @Override
    public List<CourseVo> selectAllVo() {
     List<CourseVo> courseVos = new ArrayList<>();
        List<Course> courseList = selectAll();
        for(Course course:courseList){
            courseVos.add(replace(course));
        }
        return courseVos;
    }

    private CourseVo replace(Course course) {
        CourseVo courseVo = new CourseVo();
        courseVo.setCId(course.getcId());
        courseVo.setCName(course.getcName());
        courseVo.setCLogourl(course.getcLogourl());
        courseVo.setCtime(course.getCtime());
        courseVo.setDetail(course.getDetail());
        //查询老师的名字
        courseVo.setTName(userService.selectById(teacherService.selectById(course.gettId()).getuId()).getuName());
        return courseVo;
    }
}
