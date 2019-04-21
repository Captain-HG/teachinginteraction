package com.lzc.teachingInteraction.vo;

import lombok.Data;

@Data
public class CourseUserVo {
    private String uId;
    private String cId;
    private String cName;
    private int ctime;
    private String detail;//详细介绍
    private String cLogourl;//课程头像
    private int chance;//选择数(有多少学生选择学习)
    private Byte state;
}
