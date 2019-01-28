package com.lzc.teachingInteraction.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Evaluate implements Serializable {
    @Id
    @Column(name = "e_id")
    private String eId;

    @Column(name = "m_id")
    private String mId;

    @Column(name = "t_id")
    private String tId;

    @Column(name = "exam_id")
    private String examId;

    @Column(name = "u_id")
    private String uId;

    @Column(name = "c_id")
    private String cId;

    @Column(name = "e_text")
    private String eText;

    @Column(name = "cTime")
    private Integer ctime;

    private String remark;

    private Byte type;

    private static final long serialVersionUID = 1L;

    /**
     * @return e_id
     */
    public String geteId() {
        return eId;
    }

    /**
     * @param eId
     */
    public void seteId(String eId) {
        this.eId = eId;
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
     * @return t_id
     */
    public String gettId() {
        return tId;
    }

    /**
     * @param tId
     */
    public void settId(String tId) {
        this.tId = tId;
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
     * @return e_text
     */
    public String geteText() {
        return eText;
    }

    /**
     * @param eText
     */
    public void seteText(String eText) {
        this.eText = eText;
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
        sb.append(", eId=").append(eId);
        sb.append(", mId=").append(mId);
        sb.append(", tId=").append(tId);
        sb.append(", examId=").append(examId);
        sb.append(", uId=").append(uId);
        sb.append(", cId=").append(cId);
        sb.append(", eText=").append(eText);
        sb.append(", ctime=").append(ctime);
        sb.append(", remark=").append(remark);
        sb.append(", type=").append(type);
        sb.append("]");
        return sb.toString();
    }
}