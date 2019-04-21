package com.lzc.teachingInteraction.vo;

import lombok.Data;

@Data
public class AdviseVo {
    private String adId;
    private String userId;
    private String adName;
    private String adEmail;
    private String message;
    private Integer ctime;
    private Byte state;//状态
    private String userName;//用户名
}
