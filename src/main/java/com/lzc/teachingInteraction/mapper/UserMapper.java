package com.lzc.teachingInteraction.mapper;

import com.lzc.teachingInteraction.entity.User;
import com.lzc.teachingInteraction.utils.IBaseMapper;
import java.util.List;
import java.util.Map;

public interface UserMapper extends IBaseMapper<User> {
    /** 根据type查询*/
    List<User> selectByType(Integer type);
    /** 根据账号密码查询对象
     * @param map*/
    List<User> selectByAccountAndPassword(Map<String, Object> map);
    /** 根据账号查询*/
    User selectByAccount(Integer account);
}