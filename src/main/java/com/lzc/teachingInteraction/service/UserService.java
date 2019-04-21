package com.lzc.teachingInteraction.service;


import com.lzc.teachingInteraction.entity.User;

import java.util.List;

public interface UserService {


    /** 根据主键查询*/
    User selectById(String uId);
    /** 查询所有的老师*/
    List<User> selectByTeacher();
    /** 登录判断*/
    String  loginSure(String account, String password);
    /** 根据账号查询*/
    User selectByAccount(String account);
    /** 查询所有user*/
    List<User> selectAll();
    /** 增加用户*/
    void add(User user, String  schoolName, String grade);
    /** 修改用户*/
    void update(User user, String schoolName, String grade);
    /** 删除用户*/
    void del(String uId);
    /** 启用用户,并将该用户的相关内容启用如课程、身份*/
    void start(String uId);
    /** 禁用用户*/
    void stop(String uId);
    /** 设置最近上线时间*/
    void setOntime(User user);
}
