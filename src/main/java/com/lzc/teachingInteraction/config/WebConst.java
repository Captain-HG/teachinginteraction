package com.lzc.teachingInteraction.config;

public class WebConst {
     /**考试类型为0，为期末考试 */
    public static final byte EXAM_TYPE_LAST=0;
     /** 为1，为章节测试*/
    public static final byte EXAM_TYPE_MATERIAL=1;
    /**user为1，老师*/
    public static final byte USER_TYPE_TEACHER=1;
    /**user为0，学生*/
    public static final byte USER_TYPE_STUDENT=0;
    /**user为2，管理员*/
    public static final byte USER_TYPE_ADNIN=2;
    /** session名字*/
    public static final String USER_SESSION="user";
    /**用户状态 不能使用(适用于所有状态操作)*/
    public static final byte USER_STATE_NOUSE=0;
    /**用户状态 能使用(适用于所有状态操作)*/
    public static final byte USER_STATE_YESUSE=1;
    /**用户状态 需完善，交给用户自己操作*/
    public static final byte USER_STATE_PERFECE=2;
    /** 评价类型 评价课程 0*/
    public static final byte EVALUATE_TYPE_COURSE=0;
    /** 评价类型 评价章节资料 1*/
    public static final byte EVALUATE_TYPE_MATERIAL=1;
    /** 评价类型 评价老师 2*/
    public static final byte EVALUATE_TYPE_TEACHER=2;
    /** 评价类型 评价考试 3*/
    public static final byte EVALUATE_TYPE_EXAM=3;
    /** 队列状态 已读*/
    public static final byte QUEUE_READE=1;
    /** 队列状态 未读*/
    public static final byte QUEUE_NOREADE=0;
}
