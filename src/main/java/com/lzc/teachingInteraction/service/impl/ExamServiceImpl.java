package com.lzc.teachingInteraction.service.impl;

import com.lzc.teachingInteraction.entity.Exam;
import com.lzc.teachingInteraction.entity.Subject;
import com.lzc.teachingInteraction.mapper.ExamMapper;
import com.lzc.teachingInteraction.service.ExamService;
import com.lzc.teachingInteraction.service.MaterialService;
import com.lzc.teachingInteraction.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    ExamMapper examMapper;
    @Autowired
    SubjectService subjectService;

    @Override
    public int scoreEqual(List<Integer> list, String eId) {
        int score=0;//分数初始为0
        List<Integer> sureList = subjectService.selectSureByEId(eId);//正确答案集合
        System.out.println("正确答案集合："+sureList);
        for (int i=0;i<sureList.size();i++){
            if (sureList.get(i)==list.get(i)){
                score++;
            }
        }
        System.out.println("最终得分："+score);
        return score;
    }

    @Override
    public Exam selectByMId(String mId) {
        return examMapper.selectByMId(mId);
    }

    @Override
    public Exam selectByCIdAndType(String cId, Integer examTypeLast) {
        return examMapper.selectByCIdAndType(cId,examTypeLast);
    }
}
