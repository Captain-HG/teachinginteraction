package com.lzc.teachingInteraction.mapper;

import com.lzc.teachingInteraction.entity.Advise;
import com.lzc.teachingInteraction.entity.AdviseExample;
import com.lzc.teachingInteraction.utils.IBaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdviseMapper extends IBaseMapper<Advise> {
    /** 根据uId查询所有建议*/
    List<Advise> selectAllByUId(String uId);
}