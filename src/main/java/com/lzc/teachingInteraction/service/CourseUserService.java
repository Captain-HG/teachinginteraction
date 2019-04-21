package com.lzc.teachingInteraction.service;

import com.lzc.teachingInteraction.entity.CourseUser;
import com.lzc.teachingInteraction.entity.User;
import com.lzc.teachingInteraction.vo.CourseUserVo;

import java.util.List;

public interface CourseUserService {
    /** 根据uId查询所收藏的课程*/
    List<CourseUserVo> selectAllByUId(String getuId);
    /** 根据登录用户与课程id删除收藏课程*/
    void del(String getuId, String cId);
    /** 根据登录用户查看是否已存在*/
    String isExit(String getcId, String getuId);
    /** 增加收藏课程*/
    void add(String getuId, String cId);
    /** 根据课程id，选出选择该课程的学生*/
    List<User> selectAllByCId(String cId);
}
