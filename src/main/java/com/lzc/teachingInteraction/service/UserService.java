package com.lzc.teachingInteraction.service;

import com.lzc.teachingInteraction.entity.Course;
import com.lzc.teachingInteraction.entity.User;

public interface UserService {
    /** 根据主键查询*/
    User selectById(String uId);

}
