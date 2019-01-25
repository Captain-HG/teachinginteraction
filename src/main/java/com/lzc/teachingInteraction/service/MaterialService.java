package com.lzc.teachingInteraction.service;

import com.lzc.teachingInteraction.entity.Material;

import java.util.List;

public interface MaterialService {
    /** 根据课程id，查找所有资料*/
    List<Material> selectAllByCId(String cId);
}
