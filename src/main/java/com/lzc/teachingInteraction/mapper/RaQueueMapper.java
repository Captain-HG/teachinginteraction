package com.lzc.teachingInteraction.mapper;

import com.lzc.teachingInteraction.entity.RaQueue;
import com.lzc.teachingInteraction.entity.RaQueueExample;
import com.lzc.teachingInteraction.utils.IBaseMapper;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RaQueueMapper extends IBaseMapper<RaQueue> {
    /** 查看登录用户未读信息*/
    List<RaQueue> selectAllByToUIdAndState(HashMap<String, Object> map);
    /** 查看登录用户未读信息数量*/
    int selectCountByToUIdAndState(HashMap<String, Object> map);
}