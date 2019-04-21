package com.lzc.teachingInteraction.mapper;

import com.lzc.teachingInteraction.entity.Teacher;
import com.lzc.teachingInteraction.entity.TeacherExample;
import com.lzc.teachingInteraction.utils.IBaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper extends IBaseMapper<Teacher> {
    Teacher selectByUId(String uId);
}