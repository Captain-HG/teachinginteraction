package com.lzc.teachingInteraction.service;

import com.lzc.teachingInteraction.entity.Subject;

import java.util.List;

public interface SubjectService {
    /** 根据考试id查询题库*/
    List<Subject> selectALLByEId(String eId);
}
