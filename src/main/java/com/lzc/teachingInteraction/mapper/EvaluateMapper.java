package com.lzc.teachingInteraction.mapper;

import com.lzc.teachingInteraction.entity.Evaluate;
import com.lzc.teachingInteraction.entity.EvaluateExample;
import com.lzc.teachingInteraction.utils.IBaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EvaluateMapper extends IBaseMapper<Evaluate> {
    /** 根据课程id查询所有的评价*/
    List<Evaluate> selectAllByCId(String cId);
}