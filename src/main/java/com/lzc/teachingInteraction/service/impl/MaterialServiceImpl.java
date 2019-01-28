package com.lzc.teachingInteraction.service.impl;

import com.lzc.teachingInteraction.entity.Material;
import com.lzc.teachingInteraction.mapper.MaterialMapper;
import com.lzc.teachingInteraction.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {
   @Autowired
    MaterialMapper materialMapper;

    @Override
    public List<Material> selectAllByCId(String cId) {
        return materialMapper.selectAllByCId(cId);
    }

    @Override
    public Material selectById(String id) {
        return materialMapper.selectByPrimaryKey(id);
    }
}
