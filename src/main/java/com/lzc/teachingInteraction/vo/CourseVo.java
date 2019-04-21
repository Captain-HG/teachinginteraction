package com.lzc.teachingInteraction.vo;

import lombok.Data;

@Data
public class CourseVo {
    private String cId;//课程id
    private String tName;//老师姓名
    private String cName;//课程名
    private String detail;//详细介绍
    private Integer ctime;//创建时间
    private String cLogourl;//课程头像
    private int chance;//选择数(有多少学生选择学习)
    private Byte state;//状态

}
