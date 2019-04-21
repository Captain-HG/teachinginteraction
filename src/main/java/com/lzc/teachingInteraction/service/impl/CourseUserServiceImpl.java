package com.lzc.teachingInteraction.service.impl;

import com.lzc.teachingInteraction.entity.Course;
import com.lzc.teachingInteraction.entity.CourseUser;
import com.lzc.teachingInteraction.entity.User;
import com.lzc.teachingInteraction.mapper.CourseUserMapper;
import com.lzc.teachingInteraction.service.CourseServcice;
import com.lzc.teachingInteraction.service.CourseUserService;
import com.lzc.teachingInteraction.service.UserService;
import com.lzc.teachingInteraction.utils.DateKit;
import com.lzc.teachingInteraction.vo.CourseUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CourseUserServiceImpl implements CourseUserService {
    @Autowired
    CourseUserMapper courseUserMapper;
    @Autowired
    CourseServcice courseServcice;
    @Autowired
    UserService userService;

    @Override
    public List<CourseUserVo> selectAllByUId(String getuId) {
        List<CourseUser> courseUsers = courseUserMapper.selectAllByUId(getuId);
        List<CourseUserVo> cuVo = new ArrayList<>();
        for (CourseUser courseUser:courseUsers){
            cuVo.add(replace(courseUser));
        }
        return cuVo;
    }

    @Override
    public void del(String getuId, String cId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("uId",getuId);
        map.put("cId",cId);
        courseUserMapper.del(map);
        courseServcice.delChange(cId);
    }

    @Override
    public String isExit(String getcId, String getuId) {
        Map<String,String> map = new HashMap<>();
        map.put("cId",getcId);
        map.put("uId",getuId);
        CourseUser courseUser = courseUserMapper.selectByCIdAndUId(map);
        if (courseUser!=null) {
            return "已收藏";
        }else {
            return "未收藏";
        }
    }

    @Override
    public void add(String getuId, String cId) {
        CourseUser courseUser = new CourseUser();
        courseUser.setcId(cId);
        courseUser.setuId(getuId);
        courseUser.setCtime(DateKit.getCurrentUnixTime());
        courseServcice.addChange(cId);
        courseUserMapper.insert(courseUser);
    }

    @Override
    public List<User> selectAllByCId(String cId) {
        List<CourseUser> courseUsers = courseUserMapper.selectAllByCId(cId);
        List<User> users = new ArrayList<>();
        for(CourseUser courseUser:courseUsers){
            users.add(userService.selectById(courseUser.getuId()));
        }
        return users;
    }

    private CourseUserVo replace(CourseUser courseUser) {
        CourseUserVo courseUserVo = new CourseUserVo();
        Course course = courseServcice.selectById(courseUser.getcId());
        courseUserVo.setUId(courseUser.getuId());
        courseUserVo.setCId(courseUser.getcId());
        courseUserVo.setCtime(courseUser.getCtime());
        courseUserVo.setCName(course.getcName());
        courseUserVo.setState(course.getState());
        courseUserVo.setDetail(course.getDetail());
        courseUserVo.setChance(course.getChance());
        courseUserVo.setCLogourl(course.getcLogourl());
        return courseUserVo;
    }
}
