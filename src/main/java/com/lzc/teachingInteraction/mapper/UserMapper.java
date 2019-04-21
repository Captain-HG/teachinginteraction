package com.lzc.teachingInteraction.mapper;

import com.lzc.teachingInteraction.entity.User;
import com.lzc.teachingInteraction.entity.UserExample;
import com.lzc.teachingInteraction.utils.IBaseMapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserMapper extends IBaseMapper<User> {
    /** 根据账号类型查询*/
    List<User> selectByType(Integer userTypeTeacher);
    /** 账号密码查询*/
    List<User> selectByAccountAndPassword(Map<String,String> map);
    /** 根据账号查询*/
    User selectByAccount(String account);
}