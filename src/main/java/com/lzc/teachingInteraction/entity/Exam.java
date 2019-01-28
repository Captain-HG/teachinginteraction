package com.lzc.teachingInteraction.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Exam implements Serializable {
    @Id
    @Column(name = "exam_id")
    private String examId;

    @Column(name = "m_id")
    private String mId;

    @Column(name = "c_id")
    private String cId;

    private Integer score;

    @Column(name = "cTime")
    private Integer ctime;

    private String remark;

    @Column(name = "exame_time")
    private Integer exameTime;

    private Byte type;

    private static final long serialVersionUID = 1L;

    /**
     * @return exam_id
     */
    public String getExamId() {
        return examId;
    }

    /**
     * @param examId
     */
    public void setExamId(String examId) {
        this.examId = examId;
    }

    /**
     * @return m_id
     */
    public String getmId() {
        return mId;
    }

    /**
     * @param mId
     */
    public void setmId(String mId) {
        this.mId = mId;
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
     * @return score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(Integer score) {
        this.score = score;
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

    /**
     * @return exame_time
     */
    public Integer getExameTime() {
        return exameTime;
    }

    /**
     * @param exameTime
     */
    public void setExameTime(Integer exameTime) {
        this.exameTime = exameTime;
    }

    /**
     * @return type
     */
    public Byte getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(Byte type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", examId=").append(examId);
        sb.append(", mId=").append(mId);
        sb.append(", cId=").append(cId);
        sb.append(", score=").append(score);
        sb.append(", ctime=").append(ctime);
        sb.append(", remark=").append(remark);
        sb.append(", exameTime=").append(exameTime);
        sb.append(", type=").append(type);
        sb.append("]");
        return sb.toString();
    }
}