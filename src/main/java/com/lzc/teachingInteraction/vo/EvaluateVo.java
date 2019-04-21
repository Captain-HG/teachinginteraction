package com.lzc.teachingInteraction.vo;

import lombok.Data;

@Data
public class EvaluateVo {
    private String eId;
    private String uName;
    private String eText;
    private Integer ctime;
    private String evObject;//评价对象
    private String score;//评分
}
