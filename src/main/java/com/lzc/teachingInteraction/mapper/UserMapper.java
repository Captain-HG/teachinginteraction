package com.lzc.teachingInteraction.mapper;

import com.lzc.teachingInteraction.entity.User;
import com.lzc.teachingInteraction.utils.IBaseMapper;
import java.util.List;

public interface UserMapper extends IBaseMapper<User> {
    /** 根据type查询*/
    List<User> selectByType(Integer type);
}