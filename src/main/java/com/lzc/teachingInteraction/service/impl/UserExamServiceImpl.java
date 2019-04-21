package com.lzc.teachingInteraction.service.impl;

import com.lzc.teachingInteraction.entity.User;
import com.lzc.teachingInteraction.entity.UserExam;
import com.lzc.teachingInteraction.mapper.UserExamMapper;
import com.lzc.teachingInteraction.service.*;
import com.lzc.teachingInteraction.utils.DateKit;
import com.lzc.teachingInteraction.vo.UserExamVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class UserExamServiceImpl  implements UserExamService {
    @Autowired
    UserExamMapper userExamMapper;
    @Autowired
    UserService userService;
    @Autowired
    ExamService examService;
    @Autowired
    CourseServcice courseServcice;
    @Autowired
    MaterialService materialService;

    @Override
    @Transactional
    public List<UserExamVo> selectAllByEId(String eId) {
        List<UserExam> userExamList = userExamMapper.selectAllByEId(eId);
        List<UserExamVo> userExamVos = new ArrayList<>();
        for (UserExam userExam:userExamList){
            userExamVos.add(replace(userExam));
        }
        return userExamVos;
    }

    @Override
    public void insert(String eId, Integer score) {
        User user  = (User) SecurityUtils.getSubject().getPrincipal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("uId",user.getuId());
        map.put("eId",eId);
        if(userExamMapper.selectByUIdAndEId(map)!=null){
            userExamMapper.delByUIdAndEId(map);
        }
        UserExam userExam = new UserExam();
        userExam.setuId( user.getuId());
        userExam.setExamId(eId);
        userExam.setCtime(DateKit.getCurrentUnixTime());
        userExam.setResultScore(score);
        userExamMapper.insert(userExam);
    }

    @Override
    public List<UserExamVo> selectAllByUId(String uId) {
        List<UserExam> userExamList = userExamMapper.selectAllByUId(uId);
        List<UserExamVo> userExamVos = new ArrayList<>();
        for (UserExam userExam:userExamList){
            userExamVos.add(replace(userExam));
        }
        return userExamVos;
    }

    private UserExamVo replace(UserExam userExam) {
        UserExamVo userExamVo = new UserExamVo();
        userExamVo.setUserName(userService.selectById(userExam.getuId()).getuName());
        userExamVo.setUId(userExam.getuId());
        userExamVo.setResultScore(userExam.getResultScore());
        userExamVo.setExamId(userExam.getExamId());
        userExamVo.setCtime(userExam.getCtime());
        String cId = examService.selectById(userExam.getExamId()).getcId();
        String mId = examService.selectById(userExam.getExamId()).getmId();
        String cName = courseServcice.selectById(cId).getcName();
        String mName="";
        if(StringUtils.isNotBlank(mId)){
           mName = materialService.selectById(mId).getmName();
            userExamVo.setCourseMaterial("课程："+cName+"章节资料:"+mName+",普通测试");
        }
        else {
            userExamVo.setCourseMaterial("课程："+cName+",最终测验");

        }

        return userExamVo;
    }
}
