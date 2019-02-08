package com.lzc.teachingInteraction.service.impl;

import com.lzc.teachingInteraction.entity.Evaluate;
import com.lzc.teachingInteraction.mapper.EvaluateMapper;
import com.lzc.teachingInteraction.service.CourseServcice;
import com.lzc.teachingInteraction.service.EvaluateService;
import com.lzc.teachingInteraction.service.UserService;
import com.lzc.teachingInteraction.vo.EvaluateCourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EvaluateServiceImpl implements EvaluateService {
    @Autowired
    EvaluateMapper evaluateMapper;
    @Autowired
    CourseServcice courseServcice;
    @Autowired
    UserService userService;

    @Override
    public List<Evaluate> selectAllByCId(String cId) {
        return evaluateMapper.selectAllByCId(cId);
    }

    @Override
    public List<EvaluateCourseVo> selectECVoByCId(String cId) {
           List<EvaluateCourseVo> evaluateCourseVos = new ArrayList<>();
        List<Evaluate> evaluates = selectAllByCId(cId);
        for (Evaluate evaluate:evaluates){
            evaluateCourseVos.add(replace(evaluate));
        }
        return evaluateCourseVos;
    }

    private EvaluateCourseVo replace(Evaluate evaluate) {
        EvaluateCourseVo ecVo = new EvaluateCourseVo();
        ecVo.setCId(evaluate.getcId());
        ecVo.setCTime(evaluate.getCtime());
        ecVo.setEId(evaluate.geteId());
        ecVo.setText(evaluate.geteText());
        //根据课程id查询名字
        ecVo.setCName(courseServcice.selectById(evaluate.getcId()).getcName());
        ecVo.setUId(evaluate.getuId());
        ecVo.setUName(userService.selectById(evaluate.getuId()).getuName());
        ecVo.setUImg(userService.selectById(evaluate.getuId()).getHeadimg());
        ecVo.setScore(evaluate.getRemark());
        return ecVo;
    }
}
