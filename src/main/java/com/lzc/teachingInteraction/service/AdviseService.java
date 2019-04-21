package com.lzc.teachingInteraction.service;

import com.lzc.teachingInteraction.entity.Advise;
import com.lzc.teachingInteraction.vo.AdviseVo;

import java.util.List;

public interface AdviseService {
    /** 保存意见*/
    int  add(Advise advise);
    /** 查询所有封装好的建议*/
    List<AdviseVo> selectAllVo();
    /** 删除*/
    void del(String aId);

    void alreadyRead(String aId);

    void noRead(String aId);
    /** 主键查询*/
    Advise selectById(String aId);
    /** 根据登录用户id查询所有他的建议*/
    List<AdviseVo> selectAllVoByUId(String getuId);
    /** 更新建议*/
    void update(Advise advise);
}
