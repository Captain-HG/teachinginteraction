package com.lzc.teachingInteraction.service;

import com.lzc.teachingInteraction.entity.Evaluate;
import com.lzc.teachingInteraction.vo.EvaluateCourseVo;
import com.lzc.teachingInteraction.vo.EvaluateVo;

import java.util.List;

public interface EvaluateService {
     /** 根据课程id，查询所有的评价*/
    List<Evaluate> selectAllByCId(String cId);
    /** 根据课程id，查询封装好的评价课程*/
    List<EvaluateCourseVo> selectECVoByCId(String cId);
    /** 封装评价，生成评价列表*/
    List<EvaluateVo> selectAll();
    /** 根据id删除*/
    void del(String eId);
    /** 封装评价，生成评价列表，根据登录用户id */
    List<EvaluateVo> selectAllByUId(String getuId);
    /** 增加评价*/
    void  add(String getuId, String cId, String text,String remark);
    /** 对章节资料评价*/
    void addByMId(String getuId, String mId, String text, String remark);
    /** 对考试评价*/
    void addByEId(String getuId, String eId, String text, String remark);
}
