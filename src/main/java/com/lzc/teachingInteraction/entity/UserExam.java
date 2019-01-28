package com.lzc.teachingInteraction.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "user_exam")
public class UserExam implements Serializable {
    @Id
    @Column(name = "u_id")
    private String uId;

    @Id
    @Column(name = "exam_id")
    private String examId;

    @Column(name = "result_score")
    private Integer resultScore;

    @Column(name = "cTime")
    private Integer ctime;

    private static final long serialVersionUID = 1L;

    /**
     * @return u_id
     */
    public String getuId() {
        return uId;
    }

    /**
     * @param uId
     */
    public void setuId(String uId) {
        this.uId = uId;
    }

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
     * @return result_score
     */
    public Integer getResultScore() {
        return resultScore;
    }

    /**
     * @param resultScore
     */
    public void setResultScore(Integer resultScore) {
        this.resultScore = resultScore;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uId=").append(uId);
        sb.append(", examId=").append(examId);
        sb.append(", resultScore=").append(resultScore);
        sb.append(", ctime=").append(ctime);
        sb.append("]");
        return sb.toString();
    }
}