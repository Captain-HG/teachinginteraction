package com.lzc.teachingInteraction.service.impl;

import com.lzc.teachingInteraction.entity.Subject;
import com.lzc.teachingInteraction.mapper.SubjectMapper;
import com.lzc.teachingInteraction.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    SubjectMapper subjectMapper;



    @Override
    public List<Subject> selectALLByEId(String eId) {
        return subjectMapper.selectALLByEId(eId);
    }
}
