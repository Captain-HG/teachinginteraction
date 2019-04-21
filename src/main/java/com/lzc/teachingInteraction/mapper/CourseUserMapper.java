package com.lzc.teachingInteraction.mapper;

import com.lzc.teachingInteraction.entity.CourseUser;
import com.lzc.teachingInteraction.entity.CourseUserExample;
import com.lzc.teachingInteraction.utils.IBaseMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CourseUserMapper extends IBaseMapper<CourseUser> {
    /** 根据用户id查询所收藏的课程*/
    List<CourseUser> selectAllByUId(String uId);
    /** 根据uId,和cId删除收藏课程
     * @param map*/
    void del(HashMap<String, String> map);
    /** 登录用户查询*/
    CourseUser selectByCIdAndUId(Map<String, String> map);
    /** 根据课程id选出已选该课程的学生*/
    List<CourseUser> selectAllByCId(String cId);
}