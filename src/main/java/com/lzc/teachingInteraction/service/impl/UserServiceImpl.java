package com.lzc.teachingInteraction.service.impl;

import com.lzc.teachingInteraction.config.WebConst;
import com.lzc.teachingInteraction.entity.User;
import com.lzc.teachingInteraction.mapper.UserMapper;
import com.lzc.teachingInteraction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
 @Autowired
    UserMapper userMapper;

    @Override
    public User selectById(String uId) {
        return userMapper.selectByPrimaryKey(uId);
    }

    @Override
    public List<User> selectByTeacher() {
        return userMapper.selectByType(WebConst.USER_TYPE_TEACHER);
    }


}
