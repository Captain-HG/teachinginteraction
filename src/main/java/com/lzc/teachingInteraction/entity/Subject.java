package com.lzc.teachingInteraction.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Subject implements Serializable {
    @Id
    @Column(name = "sub_id")
    private String subId;

    @Column(name = "c_id")
    private String cId;

    @Column(name = "sub_text")
    private String subText;

    @Column(name = "option_A")
    private String optionA;

    @Column(name = "option_B")
    private String optionB;

    @Column(name = "option_C")
    private String optionC;

    @Column(name = "option_D")
    private String optionD;

    @Column(name = "sub_sure")
    private Byte subSure;

    @Column(name = "cTime")
    private Integer ctime;

    @Column(name = "uTime")
    private Integer utime;

    private String remark;

    private static final long serialVersionUID = 1L;

    /**
     * @return sub_id
     */
    public String getSubId() {
        return subId;
    }

    /**
     * @param subId
     */
    public void setSubId(String subId) {
        this.subId = subId;
    }

    /**
     * @return c_id
     */
    public String getcId() {
        return cId;
    }

    /**
     * @param cId
     */
    public void setcId(String cId) {
        this.cId = cId;
    }

    /**
     * @return sub_text
     */
    public String getSubText() {
        return subText;
    }

    /**
     * @param subText
     */
    public void setSubText(String subText) {
        this.subText = subText;
    }

    /**
     * @return option_A
     */
    public String getOptionA() {
        return optionA;
    }

    /**
     * @param optionA
     */
    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    /**
     * @return option_B
     */
    public String getOptionB() {
        return optionB;
    }

    /**
     * @param optionB
     */
    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    /**
     * @return option_C
     */
    public String getOptionC() {
        return optionC;
    }

    /**
     * @param optionC
     */
    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    /**
     * @return option_D
     */
    public String getOptionD() {
        return optionD;
    }

    /**
     * @param optionD
     */
    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    /**
     * @return sub_sure
     */
    public Byte getSubSure() {
        return subSure;
    }

    /**
     * @param subSure
     */
    public void setSubSure(Byte subSure) {
        this.subSure = subSure;
    }

    /**
     * @return cTime
     */
    public Integer getCtime() {
        return ctime;
    }

    /**
     * @param ctime
     */
    public void setCtime(Integer ctime) {
        this.ctime = ctime;
    }

    /**
     * @return uTime
     */
    public Integer getUtime() {
        return utime;
    }

    /**
     * @param utime
     */
    public void setUtime(Integer utime) {
        this.utime = utime;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", subId=").append(subId);
        sb.append(", cId=").append(cId);
        sb.append(", subText=").append(subText);
        sb.append(", optionA=").append(optionA);
        sb.append(", optionB=").append(optionB);
        sb.append(", optionC=").append(optionC);
        sb.append(", optionD=").append(optionD);
        sb.append(", subSure=").append(subSure);
        sb.append(", ctime=").append(ctime);
        sb.append(", utime=").append(utime);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}