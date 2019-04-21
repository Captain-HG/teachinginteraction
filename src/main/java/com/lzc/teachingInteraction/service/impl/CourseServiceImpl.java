package com.lzc.teachingInteraction.service.impl;

import com.lzc.teachingInteraction.config.WebConst;
import com.lzc.teachingInteraction.entity.Course;
import com.lzc.teachingInteraction.mapper.CourseMapper;
import com.lzc.teachingInteraction.service.CourseServcice;
import com.lzc.teachingInteraction.service.TeacherService;
import com.lzc.teachingInteraction.service.UserService;
import com.lzc.teachingInteraction.utils.DateKit;
import com.lzc.teachingInteraction.utils.UUID;
import com.lzc.teachingInteraction.vo.CourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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
        List<Course> courseList = selectAllByStateYes();
        for(Course course:courseList){
            courseVos.add(replace(course));
        }
        return courseVos;
    }

    @Override
    public void update(Course course) {

        course.setUtime(DateKit.getCurrentUnixTime());
        courseMapper.updateByPrimaryKeySelective(course);
    }

    @Override
    public void del(String cId) {
        courseMapper.delete(courseMapper.selectByPrimaryKey(cId));
    }

    @Override
    public List<Course> selectBytId(String gettId) {
        return courseMapper.selectBytId(gettId);
    }

    @Override
    public void start(String getcId) {
        Course course = courseMapper.selectByPrimaryKey(getcId);
        course.setState(WebConst.USER_STATE_YESUSE);
        course.setUtime(DateKit.getCurrentUnixTime());
        courseMapper.updateByPrimaryKeySelective(course);
    }

    @Override
    public void stop(String cId) {
        Course course = courseMapper.selectByPrimaryKey(cId);
        course.setState(WebConst.USER_STATE_NOUSE);
        course.setUtime(DateKit.getCurrentUnixTime());
        courseMapper.updateByPrimaryKeySelective(course);
    }

    @Override
    public List<Course> selectAllByStateYes() {
        return courseMapper.selectAllByStateYes();
    }

    @Override
    public List<CourseVo> selectAllVoByTId(String tId) {
        List<CourseVo> courseVos = new ArrayList<>();
        List<Course> courseList = courseMapper.selectAllByTId(tId);
        for(Course course:courseList){
            courseVos.add(replace(course));
        }
        return courseVos;
    }

    @Override
    public void add(Course course) {
          course.setState(WebConst.USER_STATE_NOUSE);
          course.setCtime(DateKit.getCurrentUnixTime());
          course.setcId(UUID.UU32());
          course.setChance(0);
         courseMapper.insert(course);
    }

    @Override
    public void addChange(String cId) {
        Course course = courseMapper.selectByPrimaryKey(cId);
        course.setChance(course.getChance()+1);
        update(course);
    }

    @Override
    public void delChange(String cId) {
        Course course = courseMapper.selectByPrimaryKey(cId);
        course.setChance(course.getChance()-1);
        update(course);
    }


    private CourseVo replace(Course course) {
        CourseVo courseVo = new CourseVo();
        courseVo.setCId(course.getcId());
        courseVo.setCName(course.getcName());
        courseVo.setCLogourl(course.getcLogourl());
        courseVo.setCtime(course.getCtime());
        courseVo.setDetail(course.getDetail());
        courseVo.setChance(course.getChance());
        courseVo.setState(course.getState());
        //查询老师的名字
        courseVo.setTName(userService.selectById(teacherService.selectById(course.gettId()).getuId()).getuName());
        return courseVo;
    }


}
