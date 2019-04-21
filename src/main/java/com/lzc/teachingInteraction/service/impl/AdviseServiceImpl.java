package com.lzc.teachingInteraction.service.impl;

import com.lzc.teachingInteraction.entity.Advise;
import com.lzc.teachingInteraction.mapper.AdminMapper;
import com.lzc.teachingInteraction.mapper.AdviseMapper;
import com.lzc.teachingInteraction.service.AdviseService;
import com.lzc.teachingInteraction.service.UserService;
import com.lzc.teachingInteraction.utils.DateKit;
import com.lzc.teachingInteraction.utils.UUID;
import com.lzc.teachingInteraction.vo.AdviseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdviseServiceImpl implements AdviseService {
    @Autowired
    AdviseMapper adviseMapper;
    @Autowired
    UserService userService;

    @Override
    public int add(Advise advise) {

        advise.setState((byte)0);
        advise.setAdId(UUID.UU32());
        advise.setCtime(DateKit.getCurrentUnixTime());
        int i = adviseMapper.insert(advise);
        return i;
    }

    @Override
    public List<AdviseVo> selectAllVo() {
      List<AdviseVo> adviseVoList = new ArrayList<>();
        List<Advise> adviseList = adviseMapper.selectAll();
        for (Advise advise:adviseList){
            adviseVoList.add(replace(advise));
        }
        return adviseVoList;
    }

    @Override
    public void del(String aId) {
        adviseMapper.delete(adviseMapper.selectByPrimaryKey(aId));
    }

    @Override
    public void alreadyRead(String aId) {
        Advise advise = adviseMapper.selectByPrimaryKey(aId);
        advise.setState((byte) 1);
        adviseMapper.updateByPrimaryKeySelective(advise);
    }

    @Override
    public void noRead(String aId) {
        Advise advise = adviseMapper.selectByPrimaryKey(aId);
        advise.setState((byte) 0);
        adviseMapper.updateByPrimaryKeySelective(advise);
    }

    @Override
    public Advise selectById(String aId) {
        return adviseMapper.selectByPrimaryKey(aId);
    }

    @Override
    public List<AdviseVo> selectAllVoByUId(String getuId) {
        List<AdviseVo> adviseVoList = new ArrayList<>();
        List<Advise> adviseList = adviseMapper.selectAllByUId(getuId);
        for (Advise advise:adviseList){
            adviseVoList.add(replace(advise));
        }
        return adviseVoList;
    }

    @Override
    public void update(Advise advise) {
        adviseMapper.updateByPrimaryKeySelective(advise);
    }

    private AdviseVo replace(Advise advise) {
        AdviseVo adviseVo = new AdviseVo();
        adviseVo.setUserId(advise.getUserId());
        adviseVo.setCtime(advise.getCtime());
        adviseVo.setState(advise.getState());
        adviseVo.setMessage(advise.getMessage());
        adviseVo.setAdName(advise.getAdName());
        adviseVo.setAdId(advise.getAdId());
        adviseVo.setUserName(userService.selectById(advise.getUserId()).getuName());
        adviseVo.setAdEmail(advise.getAdEmail());
        return adviseVo;
    }
}
