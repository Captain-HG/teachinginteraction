package com.lzc.teachingInteraction.mapper;

import com.lzc.teachingInteraction.entity.Admin;
import com.lzc.teachingInteraction.entity.AdminExample;
import com.lzc.teachingInteraction.utils.IBaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper extends IBaseMapper<Admin> {
    Admin selectByUId(String uId);
}