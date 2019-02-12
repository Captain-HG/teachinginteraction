package com.lzc.teachingInteraction.config;

public class WebConst {
     /**考试类型为0，为期末考试 */
    public static final Integer EXAM_TYPE_LAST=0;
     /** 为1，为章节测试*/
    public static final Integer EXAM_TYPE_MATERIAL=1;
    /**user为1，老师*/
    public static final Integer USER_TYPE_TEACHER=1;
    /**user为0，学生*/
    public static final Integer USER_TYPE_STUDENT=0;
    /**user为2，管理员*/
    public static final Integer USER_TYPE_ADNIN=2;
    /** session名字*/
    public static final String USER_SESSION="user";
}
