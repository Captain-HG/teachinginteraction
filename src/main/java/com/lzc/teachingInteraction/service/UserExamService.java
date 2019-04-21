package com.lzc.teachingInteraction.service;

import com.lzc.teachingInteraction.entity.UserExam;
import com.lzc.teachingInteraction.vo.UserExamVo;

import java.util.List;

public interface UserExamService {
    /** 根据考试id查询该考试的记录*/
    List<UserExamVo> selectAllByEId(String eId);
    /** 添加记录*/
    void insert(String eId,Integer score);
    /** 根据登录用户id查询它的考试记录*/
    List<UserExamVo> selectAllByUId(String uId);
}
