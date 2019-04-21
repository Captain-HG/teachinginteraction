package com.lzc.teachingInteraction.vo;

import lombok.Data;

@Data
public class UserExamVo {
    private String uId;
    private String examId;
    private Integer resultScore;
    private Integer ctime;
    private String userName;
    private String courseMaterial;//哪个课程+哪个章节资料
}
