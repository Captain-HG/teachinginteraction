package com.lzc.teachingInteraction.service;

import com.lzc.teachingInteraction.entity.Subject;

import java.util.List;

public interface SubjectService {
    /** 根据考试id查询题库*/
    List<Subject> selectALLByEId(String eId);
    /** 根据考试id查询题库答案集合*/
    List<Integer> selectSureByEId(String eId);
    /** 增加一个题目*/
    void add(Subject subject);
    /** 查询根据主键*/
    Subject selectById(String sId);
    /** 跟新*/
    void update(Subject subject);
    /** 删除根据id*/
    void del(String sId);
}
