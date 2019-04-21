package com.lzc.teachingInteraction.service;

import com.lzc.teachingInteraction.entity.Student;

public interface StudentService {
    void add(String getuId, String schoolName, String grade);
     /** 根据uid查询*/
    Student selectByUId(String getuId);
    /** 检查是否已经存在该字段*/
    void checkAndUpdate(String getuId, String schoolName, String grade);
    /**改变学生的状态*/
    void changeState(String sId, byte state);
}
