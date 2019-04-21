package com.lzc.teachingInteraction.vo;

import lombok.Data;

/**
 * 对考试的封装
 */
@Data
public class ExamVo {
  private  String eId;//考试id
  private  String mName;//相对应的资料
  private String cNmae;//课程名字
  private int ctime;
  private Byte type;
  private Integer score;
}
