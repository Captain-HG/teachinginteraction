package com.lzc.teachingInteraction.service.impl;

import com.lzc.teachingInteraction.entity.Course;
import com.lzc.teachingInteraction.entity.Material;
import com.lzc.teachingInteraction.mapper.MaterialMapper;
import com.lzc.teachingInteraction.service.CourseServcice;
import com.lzc.teachingInteraction.service.MaterialService;
import com.lzc.teachingInteraction.utils.DateKit;
import com.lzc.teachingInteraction.utils.UUID;
import com.lzc.teachingInteraction.vo.CourseVo;
import com.lzc.teachingInteraction.vo.MaterialVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {
   @Autowired
    MaterialMapper materialMapper;
   @Autowired
    CourseServcice courseServcice;

    @Override
    public List<Material> selectAllByCId(String cId) {
        return materialMapper.selectAllByCId(cId);
    }

    @Override
    public Material selectById(String id) {
        return materialMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<MaterialVo> selectAllVo() {
       List<MaterialVo> materialVos = new ArrayList<>();
        List<Material> materials = materialMapper.selectAll();
        for(Material material:materials){
            materialVos.add(replace(material));
        }
        return materialVos;
    }

    @Override
    public void update(Material material) {
        materialMapper.updateByPrimaryKeySelective(material);
    }

    @Override
    public void del(String mId) {
        materialMapper.delete(materialMapper.selectByPrimaryKey(mId));
    }

    @Override
    public void add(Material material) {
        material.setmId(UUID.UU32());
        material.setCtime(DateKit.getCurrentUnixTime());
        material.setDownNum(0);
        materialMapper.insert(material);
    }

    @Override
    public List<MaterialVo> selectAllVoByCId(String cId) {
        List<MaterialVo> materialVos = new ArrayList<>();
        List<Material> materialList = materialMapper.selectAllByCId(cId);
        for(Material material:materialList){
            materialVos.add(replace(material));
        }
        return materialVos;
    }

    @Override
    public void downNumUpdate(String mId) {
        Material material = materialMapper.selectByPrimaryKey(mId);
        material.setDownNum(material.getDownNum()+1);
        update(material);
    }

    private MaterialVo replace(Material material) {
        MaterialVo vo = new MaterialVo();
        vo.setMId(material.getmId());
        vo.setUrl(material.getUrl());
        vo.setMType(material.getmType());
        vo.setMName(material.getmName());
        vo.setDownNum(material.getDownNum());
        vo.setCtime(material.getCtime());
        vo.setCName(courseServcice.selectById(material.getcId()).getcName());
        return vo;
    }
}
