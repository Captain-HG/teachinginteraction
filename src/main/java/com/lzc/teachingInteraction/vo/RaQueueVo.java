package com.lzc.teachingInteraction.vo;

import lombok.Data;

@Data
public class RaQueueVo {
    private String qId;
    private Byte state;
    private String fromUid;
    private Integer ctime;
    private String uName;//发送者姓名
    private Byte type;//发送者身份
}
