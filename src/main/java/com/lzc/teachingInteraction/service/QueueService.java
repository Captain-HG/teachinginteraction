package com.lzc.teachingInteraction.service;

import com.lzc.teachingInteraction.entity.RaQueue;
import com.lzc.teachingInteraction.vo.RaQueueVo;

import java.util.List;

public interface QueueService {
    /** 保存这一消息记录 s为保存信息的队列名,fromUserId为谁发给我的，那么我需要回复*/
    void add(String s, String fromUserId,String toUserId);

    /**
     * 查询所有状态为未读的，登录用户id，封装好
     * @param uId
     * @return
     */
    List<RaQueueVo> selectAllByToUIdAndState(String uId);
    /** 只是返回未读信息个数*/
    int selectAllByToUIdAndStateSize(String getuId);
    /** 主键查询*/
    RaQueue selectById(String qId);
    /** 读取信息后rabbitmq将会把信息去掉*/
    void update(String qId);
}
