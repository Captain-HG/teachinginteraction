package com.lzc.teachingInteraction.service.impl;

import com.lzc.teachingInteraction.entity.Subject;
import com.lzc.teachingInteraction.mapper.SubjectMapper;
import com.lzc.teachingInteraction.service.SubjectService;
import com.lzc.teachingInteraction.utils.DateKit;
import com.lzc.teachingInteraction.utils.UUID;
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

    @Override
    public List<Integer> selectSureByEId(String eId) {
        return subjectMapper.selectSureByEId(eId);
    }

    @Override
    public void add(Subject subject) {
        subject.setSubId(UUID.UU32());
        subject.setCtime(DateKit.getCurrentUnixTime());
        subjectMapper.insert(subject);
    }

    @Override
    public Subject selectById(String sId) {
        return subjectMapper.selectByPrimaryKey(sId);
    }

    @Override
    public void update(Subject subject) {
        subject.setUtime(DateKit.getCurrentUnixTime());
        subjectMapper.updateByPrimaryKeySelective(subject);
    }

    @Override
    public void del(String sId) {
       subjectMapper.delete(subjectMapper.selectByPrimaryKey(sId));
    }

}
