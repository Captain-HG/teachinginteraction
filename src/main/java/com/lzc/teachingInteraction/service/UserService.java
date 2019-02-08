package com.lzc.teachingInteraction.service;

import com.lzc.teachingInteraction.entity.Course;
import com.lzc.teachingInteraction.entity.User;

import java.util.List;

public interface UserService {
    /** 根据主键查询*/
    User selectById(String uId);
    /** 查询所有的老师*/
    List<User> selectByTeacher();
}
