package com.lzc.teachingInteraction.service.impl;

import com.lzc.teachingInteraction.entity.Advise;
import com.lzc.teachingInteraction.mapper.AdminMapper;
import com.lzc.teachingInteraction.mapper.AdviseMapper;
import com.lzc.teachingInteraction.service.AdviseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdviseServiceImpl implements AdviseService {
    @Autowired
    AdviseMapper adviseMapper;

    @Override
    public int add(Advise advise) {
        int i = adviseMapper.insert(advise);
        return i;
    }
}
