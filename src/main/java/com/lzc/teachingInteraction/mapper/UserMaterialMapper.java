package com.lzc.teachingInteraction.mapper;

import com.lzc.teachingInteraction.entity.UserMaterial;
import com.lzc.teachingInteraction.entity.UserMaterialExample;
import com.lzc.teachingInteraction.utils.IBaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMaterialMapper extends IBaseMapper<UserMaterial> {
    int countByExample(UserMaterialExample example);

    int deleteByExample(UserMaterialExample example);

    List<UserMaterial> selectByExample(UserMaterialExample example);

    int updateByExampleSelective(@Param("record") UserMaterial record, @Param("example") UserMaterialExample example);

    int updateByExample(@Param("record") UserMaterial record, @Param("example") UserMaterialExample example);
}