package com.lzc.teachingInteraction.service;

import com.lzc.teachingInteraction.entity.Notice;

import java.util.List;

public interface NoticeService {
    /** 查询所有*/
    List<Notice> selectAll();
   /** 增加*/
    void add(Notice notice);
    /** id查询*/
    Notice selectById(String nId);
    /** 跟新*/
    void update(Notice notice);
    /** 删除*/
    void del(String nId);

    void start(String nId);

    void stop(String nId);
}
