package com.lzc.teachingInteraction.service.impl;

import com.lzc.teachingInteraction.config.WebConst;
import com.lzc.teachingInteraction.entity.Exam;
import com.lzc.teachingInteraction.entity.Subject;
import com.lzc.teachingInteraction.mapper.ExamMapper;
import com.lzc.teachingInteraction.service.ExamService;
import com.lzc.teachingInteraction.service.MaterialService;
import com.lzc.teachingInteraction.service.SubjectService;
import com.lzc.teachingInteraction.service.UserExamService;
import com.lzc.teachingInteraction.utils.DateKit;
import com.lzc.teachingInteraction.utils.UUID;
import com.lzc.teachingInteraction.vo.ExamVo;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.internal.engine.messageinterpolation.parser.ELState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ExamServiceImpl implements ExamService {
    @Autowired
    ExamMapper examMapper;
    @Autowired
    SubjectService subjectService;
    @Autowired
    MaterialService materialService;
    @Autowired
    CourseServiceImpl courseService;
    @Autowired
    UserExamService userExamService;

    @Override
    public List<Integer> scoreEqual(List<Integer> list, String eId) {
        List<Integer> scoreList = new ArrayList<>();//用户选中正确的list
        int score=0;//分数初始为0
        List<Integer> sureList = subjectService.selectSureByEId(eId);//正确答案集合
        System.out.println("正确答案集合："+sureList);
        for (int i=0;i<sureList.size();i++){
            if (sureList.get(i)==list.get(i)){
                score++;
                scoreList.add(i);
            }
        }
        System.out.println("最终得分："+score);
         userExamService.insert(eId,score);
        return scoreList;
    }

    @Override
    public Exam selectByMId(String mId) {
        return examMapper.selectByMId(mId);
    }

    @Override
    public Exam selectByCIdAndType(String cId, byte examTypeLast) {
        return examMapper.selectByCIdAndType(cId,examTypeLast);
    }

    @Override
    public List<ExamVo> selectAllVo() {
        List<ExamVo> examVos = new ArrayList<>();
        List<Exam> examList = examMapper.selectAll();
        for (Exam exam:examList){
            examVos.add(replace(exam));
        }
        return examVos;
    }

    @Override
    public Exam selectById(String eId) {
        return examMapper.selectByPrimaryKey(eId);
    }

    @Override
    public void update(Exam exam) {
        examMapper.updateByPrimaryKeySelective(exam);
    }

    @Override
    public void del(String eId) {
     examMapper.delete(examMapper.selectByPrimaryKey(eId));
    }

    @Override
    public void add(Exam exam) {
      exam.setExamId(UUID.UU32());
      exam.setCtime(DateKit.getCurrentUnixTime());
      exam.setScore(100);
      examMapper.insert(exam);
    }

    @Override
    public List<ExamVo> selectAllVoByTId(String tId) {
        List<ExamVo> examVos = new ArrayList<>();
        List<Exam> examList = examMapper.selectAllByTId(tId);
        for (Exam exam:examList){
            examVos.add(replace(exam));
        }
        return examVos;
    }

    private ExamVo replace(Exam exam) {
        ExamVo examVo = new ExamVo();
        examVo.setType(exam.getType());
        examVo.setScore(exam.getScore());
        if (StringUtils.isNotBlank(exam.getmId())){//期末考试或者期中考试无资料mid
            examVo.setMName(materialService.selectById(exam.getmId()).getmName());
        }else {
            System.out.println("mid为空");
            examVo.setMName(null);
        }
        examVo.setEId(exam.getExamId());
        examVo.setCtime(exam.getCtime());
        examVo.setCNmae(courseService.selectById(exam.getcId()).getcName());

        return examVo;
    }
}
