package com.lzc.teachingInteraction.service.impl;

import com.lzc.teachingInteraction.config.WebConst;
import com.lzc.teachingInteraction.entity.Notice;
import com.lzc.teachingInteraction.mapper.NoticeMapper;
import com.lzc.teachingInteraction.service.NoticeService;
import com.lzc.teachingInteraction.utils.DateKit;
import com.lzc.teachingInteraction.utils.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeMapper noticeMapper;

    @Override
    public List<Notice> selectAll() {
        return noticeMapper.selectAll();
    }

    @Override
    public void add(Notice notice) {
      notice.setnId(UUID.UU32());
      notice.setCtime(DateKit.getCurrentUnixTime());
      notice.setState(WebConst.USER_STATE_NOUSE);
      noticeMapper.insert(notice);
    }

    @Override
    public Notice selectById(String nId) {

        return noticeMapper.selectByPrimaryKey(nId);
    }

    @Override
    public void update(Notice notice) {
      noticeMapper.updateByPrimaryKeySelective(notice);
    }

    @Override
    public void del(String nId) {
       noticeMapper.delete(selectById(nId));
    }

    @Override
    public void start(String nId) {
        Notice notice = selectById(nId);
        notice.setState(WebConst.USER_STATE_YESUSE);
        update(notice);
    }

    @Override
    public void stop(String nId) {
        Notice notice = selectById(nId);
        notice.setState(WebConst.USER_STATE_NOUSE);
        update(notice);
    }
}
