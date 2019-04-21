package com.lzc.teachingInteraction.service.impl;

import com.lzc.teachingInteraction.entity.Admin;
import com.lzc.teachingInteraction.mapper.AdminMapper;
import com.lzc.teachingInteraction.service.AdminService;
import com.lzc.teachingInteraction.utils.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
      @Autowired
    AdminMapper adminMapper;

    @Override
    public void add(String getuId) {
        Admin admin = new Admin();
        admin.setaId(UUID.UU32());
        admin.setuId(getuId);
        adminMapper.insert(admin);
    }

    @Override
    public Admin selectByUId(String getuId) {
        return adminMapper.selectByUId(getuId);
    }

    @Override
    public boolean isExtis(String getuId) {
        Admin admin = adminMapper.selectByUId(getuId);
        if (admin!=null){
            return true;
        }else {
            return false;
        }
    }
}
