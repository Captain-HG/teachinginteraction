package com.lzc.teachingInteraction.service.impl;

import com.lzc.teachingInteraction.config.WebConst;
import com.lzc.teachingInteraction.entity.Course;
import com.lzc.teachingInteraction.entity.RaQueue;
import com.lzc.teachingInteraction.mapper.RaQueueMapper;
import com.lzc.teachingInteraction.service.QueueService;
import com.lzc.teachingInteraction.service.UserService;
import com.lzc.teachingInteraction.utils.DateKit;
import com.lzc.teachingInteraction.utils.UUID;
import com.lzc.teachingInteraction.vo.CourseVo;
import com.lzc.teachingInteraction.vo.RaQueueVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class QueueServiceImpl implements QueueService {
    @Autowired
    RaQueueMapper raQueueMapper;
    @Autowired
    UserService userService;
    @Override
    public void add(String s, String fromUserId,String toUserId) {
        RaQueue queue = new RaQueue();
        queue.setqId(UUID.UU32());
        queue.setState(WebConst.QUEUE_NOREADE);
        queue.setQueueName(s);
        queue.setToUid(toUserId);
        queue.setCtime(DateKit.getCurrentUnixTime());
        queue.setFromUid(fromUserId);
        raQueueMapper.insert(queue);
    }

    @Override
    public List<RaQueueVo> selectAllByToUIdAndState(String uId) {
        List<RaQueueVo> raQueueVo = new ArrayList<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("uId",uId);
        map.put("state",WebConst.QUEUE_NOREADE);
        List<RaQueue> raQueues = raQueueMapper.selectAllByToUIdAndState(map);
        for(RaQueue raQueue:raQueues){
            raQueueVo.add(replace(raQueue));
        }
        return raQueueVo;
    }

    @Override
    public int selectAllByToUIdAndStateSize(String uId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("uId",uId);
        map.put("state",WebConst.QUEUE_NOREADE);
        int i = raQueueMapper.selectCountByToUIdAndState(map);
        System.out.println(i);
        return i;
    }

    @Override
    public RaQueue selectById(String qId) {
        return raQueueMapper.selectByPrimaryKey(qId);
    }

    @Override
    public void update(String qId) {
        RaQueue raQueue = raQueueMapper.selectByPrimaryKey(qId);
        raQueue.setState(WebConst.QUEUE_READE);
        raQueueMapper.updateByPrimaryKeySelective(raQueue);
    }

    private RaQueueVo replace(RaQueue raQueue) {
        RaQueueVo raQueueVo = new RaQueueVo();
        raQueueVo.setFromUid(raQueue.getFromUid());
        raQueueVo.setCtime(raQueue.getCtime());
        raQueueVo.setState(raQueue.getState());
        raQueueVo.setQId(raQueue.getqId());
        raQueueVo.setUName(userService.selectById(raQueue.getFromUid()).getuName());
        raQueueVo.setType(userService.selectById(raQueue.getFromUid()).getType());
        return raQueueVo;
    }
}
