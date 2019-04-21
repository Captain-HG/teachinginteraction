package com.lzc.teachingInteraction.vo;

import lombok.Data;

@Data
public class MaterialVo {
    private String mId;//id
    private String cName;//来自课程
    private String mType;//资料类型
    private String mName;//资料名
    private String url;//资料地址
    private Integer ctime;//创建时间
    private Integer downNum;//下载数

}
