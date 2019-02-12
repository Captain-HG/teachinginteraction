package com.lzc.teachingInteraction.service.impl;

import com.lzc.teachingInteraction.config.WebConst;
import com.lzc.teachingInteraction.entity.User;
import com.lzc.teachingInteraction.mapper.UserMapper;
import com.lzc.teachingInteraction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public String loginSure(String account, String password) {
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("account",Integer.parseInt(account));
        map.put("password",password);
        List<User> userList = userMapper.selectByAccountAndPassword(map);
        if (userList!=null&&userList.size()>=1)
        {
            return "success";
        }
        else {
            return "您的账号或密码输入有误，请重试！！";
        }

    }

    @Override
    public User selectByAccount(String account) {
        return userMapper.selectByAccount(Integer.parseInt(account));
    }


}
