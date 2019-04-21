package com.lzc.teachingInteraction.service;

import com.lzc.teachingInteraction.entity.Course;
import com.lzc.teachingInteraction.entity.Teacher;

public interface TeacherService {
    /** 根据主键查询*/
    Teacher selectById(String tId);
    /** 增加*/
    void add(String getuId,String schoolName);
    /** 根据uId查询*/
    Teacher selectByUId(String getuId);
    /** 改变老师的状态，相应的老师的课程状态也会改变*/
    void changeState(String gettId, byte state);
    /** 检查是否有该老师，并更新他的信息*/
    void checkAndUpdate(String getuId, String schoolName);
    /** 判断有无*/
    boolean isExtis(String getuId);
}
