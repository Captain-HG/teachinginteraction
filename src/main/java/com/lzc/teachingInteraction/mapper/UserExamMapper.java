package com.lzc.teachingInteraction.mapper;

import com.lzc.teachingInteraction.entity.UserExam;
import com.lzc.teachingInteraction.entity.UserExamExample;
import com.lzc.teachingInteraction.utils.IBaseMapper;

import java.util.HashMap;
import java.util.List;

import com.lzc.teachingInteraction.vo.UserExamVo;
import org.apache.ibatis.annotations.Param;

public interface UserExamMapper extends IBaseMapper<UserExam> {
    /** 根据*/
    List<UserExam> selectAllByEId(String eId);
    /** 根据登录用户id查询考试记录*/
    List<UserExam> selectAllByUId(String uId);
    /** 根据用户id和测试id来进行查询判断*/
    UserExam selectByUIdAndEId(HashMap<String, Object> map);
    /** 删除指定的测试记录*/
    void delByUIdAndEId(HashMap<String, Object> map);
}