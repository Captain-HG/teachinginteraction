package com.lzc.teachingInteraction.vo;

import lombok.Data;

/**
 * 对课程的评价封装
 */
@Data
public class EvaluateCourseVo {
   private String eId;//评价id
   private String cId;//课程id
   private String cName;//课程名
   private String text;//评价内容
   private Integer cTime;//创建时间
    private String uId;//评论人的id
    private String uName;//评论人的名字
    private String uImg;//评论人的头像
    private String score;//打的分
}
