package com.lzc.teachingInteraction.service;

import com.lzc.teachingInteraction.entity.Material;
import com.lzc.teachingInteraction.vo.MaterialVo;

import java.util.List;

public interface MaterialService {
    /** 根据课程id，查找所有资料*/
    List<Material> selectAllByCId(String cId);
    /** 主键查询*/
    Material selectById(String id);
    /** 查询封装好的资料*/
    List<MaterialVo> selectAllVo();
    /** 更新资料*/
    void update(Material material);
    /** 删除该资料，自然他的考试也应该被删除*/
    void del(String mId);
    /** 增加资料，但是再增加资料的情况下是不增加他的测试的，考试放在考试管理中*/
    void add(Material material);
    /** 查询封装好的资料,通过课程*/
    List<MaterialVo> selectAllVoByCId(String cId);
    /** 使下载数目发生变化*/
    void downNumUpdate(String mId);
}
