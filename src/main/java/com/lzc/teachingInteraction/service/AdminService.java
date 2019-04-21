package com.lzc.teachingInteraction.service;

import com.lzc.teachingInteraction.entity.Admin;

public interface AdminService {
    void add(String getuId);
    /** 根据uID查询*/
    Admin selectByUId(String getuId);
    /** 判断是否有该管理员*/
    boolean isExtis(String getuId);
}
