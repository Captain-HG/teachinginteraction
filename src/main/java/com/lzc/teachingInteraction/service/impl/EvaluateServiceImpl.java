package com.lzc.teachingInteraction.service.impl;

import com.lzc.teachingInteraction.config.WebConst;
import com.lzc.teachingInteraction.entity.Evaluate;
import com.lzc.teachingInteraction.mapper.EvaluateMapper;
import com.lzc.teachingInteraction.service.*;
import com.lzc.teachingInteraction.utils.DateKit;
import com.lzc.teachingInteraction.utils.UUID;
import com.lzc.teachingInteraction.vo.EvaluateCourseVo;
import com.lzc.teachingInteraction.vo.EvaluateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EvaluateServiceImpl implements EvaluateService {
    @Autowired
    EvaluateMapper evaluateMapper;
    @Autowired
    CourseServcice courseServcice;
    @Autowired
    UserService userService;
    @Autowired
    MaterialService materialService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    ExamService examService;

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

    @Override
    public List<EvaluateVo> selectAll() {
        List<Evaluate> evaluateList = evaluateMapper.selectAll();
        List<EvaluateVo> evaluateVos = new ArrayList<>();
        for(Evaluate evaluate:evaluateList){
            evaluateVos.add(change(evaluate));
        }

        return evaluateVos;
    }

    @Override
    public void del(String eId) {
        Evaluate evaluate = evaluateMapper.selectByPrimaryKey(eId);
        evaluateMapper.delete(evaluate);
    }

    @Override
    public List<EvaluateVo> selectAllByUId(String getuId) {
        List<Evaluate> evaluateList = evaluateMapper.selectAllByUId(getuId);
        List<EvaluateVo> evaluateVos = new ArrayList<>();
        for(Evaluate evaluate:evaluateList){
            evaluateVos.add(change(evaluate));
        }

        return evaluateVos;
    }

    @Override
    public void add(String getuId, String cId, String text,String remark) {
        Evaluate evaluate = new Evaluate();
        evaluate.setcId(cId);
        evaluate.setuId(getuId);
        evaluate.seteText(text);
        evaluate.seteId(UUID.UU32());
        evaluate.setCtime(DateKit.getCurrentUnixTime());
        evaluate.setType(WebConst.EVALUATE_TYPE_COURSE);
        evaluate.setRemark(remark);
        evaluateMapper.insert(evaluate);

    }

    @Override
    public void addByMId(String getuId, String mId, String text, String remark) {
        Evaluate evaluate = new Evaluate();
        evaluate.setcId(materialService.selectById(mId).getcId());
        evaluate.setuId(getuId);
        evaluate.seteText(text);
        evaluate.seteId(UUID.UU32());
        evaluate.setCtime(DateKit.getCurrentUnixTime());
        evaluate.setType(WebConst.EVALUATE_TYPE_MATERIAL);
        evaluate.setRemark(remark);
        evaluate.setmId(mId);
        evaluateMapper.insert(evaluate);
    }

    @Override
    public void addByEId(String getuId, String eId, String text, String remark) {
        Evaluate evaluate = new Evaluate();
        evaluate.setmId(examService.selectById(eId).getmId());
        evaluate.setcId(examService.selectById(eId).getcId());
        evaluate.setuId(getuId);
        evaluate.seteText(text);
        evaluate.seteId(UUID.UU32());
        evaluate.setCtime(DateKit.getCurrentUnixTime());
        evaluate.setType(WebConst.EVALUATE_TYPE_EXAM);
        evaluate.setRemark(remark);
        evaluate.setExamId(eId);
        evaluateMapper.insert(evaluate);
    }

    private EvaluateVo change(Evaluate evaluate) {
        EvaluateVo vo = new EvaluateVo();
         vo.setEId(evaluate.geteId());
         vo.setCtime(evaluate.getCtime());
         vo.setEText(evaluate.geteText());
         vo.setEText(evaluate.geteText());
         vo.setUName(userService.selectById(evaluate.getuId()).getuName());
         vo.setScore(evaluate.getRemark());
        Byte evaluateType = evaluate.getType();
        switch (evaluateType){
            case WebConst.EVALUATE_TYPE_COURSE:
                String cName = courseServcice.selectById(evaluate.getcId()).getcName();//取得课程名
                 vo.setEvObject("课程:"+cName);
                 break;
            case WebConst.EVALUATE_TYPE_MATERIAL:
                String cName1 = courseServcice.selectById(evaluate.getcId()).getcName();
                String mName = materialService.selectById(evaluate.getmId()).getmName();
                vo.setEvObject("课程:"+cName1+",资料章节:"+mName);
                break;
            case WebConst.EVALUATE_TYPE_TEACHER:
                String getuName = userService.selectById(teacherService.selectById(evaluate.gettId()).getuId()).getuName();
                vo.setEvObject("老师:"+getuName);
                break;
            case WebConst.EVALUATE_TYPE_EXAM:
                vo.setEvObject("考试id:"+evaluate.getExamId());
                break;
        }
        return vo;
    }

    private EvaluateCourseVo replace(Evaluate evaluate) {
        EvaluateCourseVo ecVo = new EvaluateCourseVo();
        ecVo.setCId(evaluate.getcId());
        ecVo.setCTime(evaluate.getCtime());
        ecVo.setEId(evaluate.geteId());
        Byte evaluateType = evaluate.getType();
        switch (evaluateType){
            case WebConst.EVALUATE_TYPE_COURSE:
                ecVo.setText("课程:"+evaluate.geteText());
                break;
            case WebConst.EVALUATE_TYPE_MATERIAL:
                String mName = materialService.selectById(evaluate.getmId()).getmName();
                ecVo.setText("资料章节-"+mName+":"+evaluate.geteText());
                break;
//            case WebConst.EVALUATE_TYPE_TEACHER:
//                String getuName = userService.selectById(teacherService.selectById(evaluate.gettId()).getuId()).getuName();
//                ecVo.setEvObject("老师:"+getuName);
//                break;
            case WebConst.EVALUATE_TYPE_EXAM:
                ecVo.setText("考试id:"+evaluate.getExamId()+"："+evaluate.geteText());
                break;
        }
//        ecVo.setText(evaluate.geteText());
        //根据课程id查询名字
        ecVo.setCName(courseServcice.selectById(evaluate.getcId()).getcName());
        ecVo.setUId(evaluate.getuId());
        ecVo.setUName(userService.selectById(evaluate.getuId()).getuName());
        ecVo.setUImg(userService.selectById(evaluate.getuId()).getHeadimg());
        ecVo.setScore(evaluate.getRemark());
        return ecVo;
    }
}
