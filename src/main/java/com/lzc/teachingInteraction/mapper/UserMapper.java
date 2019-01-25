package com.lzc.teachingInteraction.mapper;

import com.lzc.teachingInteraction.entity.User;
import com.lzc.teachingInteraction.entity.UserExample;
import com.lzc.teachingInteraction.utils.IBaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends IBaseMapper<User> {
    User selectByUId(String uId);
}