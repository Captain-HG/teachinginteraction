package com.lzc.teachingInteraction.mapper;

import com.lzc.teachingInteraction.entity.Material;
import com.lzc.teachingInteraction.entity.MaterialExample;
import com.lzc.teachingInteraction.utils.IBaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterialMapper extends IBaseMapper<Material> {
    /** 根据课程id，查询所有资料*/
    List<Material> selectAllByCId(String cId);
}