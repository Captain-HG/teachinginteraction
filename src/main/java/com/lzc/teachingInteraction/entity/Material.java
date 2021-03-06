package com.lzc.teachingInteraction.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Material implements Serializable {
    @Id
    @Column(name = "m_id")
    private String mId;

    @Column(name = "c_id")
    private String cId;

    @Column(name = "exam_id")
    private String examId;

    @Column(name = "m_type")
    private String mType;

    @Column(name = "m_name")
    private String mName;

    private Integer size;

    private String url;

    @Column(name = "cTime")
    private Integer ctime;

    private String remark;

    @Column(name = "down_num")
    private Integer downNum;

    private static final long serialVersionUID = 1L;

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
     * @return m_type
     */
    public String getmType() {
        return mType;
    }

    /**
     * @param mType
     */
    public void setmType(String mType) {
        this.mType = mType;
    }

    /**
     * @return m_name
     */
    public String getmName() {
        return mName;
    }

    /**
     * @param mName
     */
    public void setmName(String mName) {
        this.mName = mName;
    }

    /**
     * @return size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * @param size
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
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
     * @return down_num
     */
    public Integer getDownNum() {
        return downNum;
    }

    /**
     * @param downNum
     */
    public void setDownNum(Integer downNum) {
        this.downNum = downNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mId=").append(mId);
        sb.append(", cId=").append(cId);
        sb.append(", examId=").append(examId);
        sb.append(", mType=").append(mType);
        sb.append(", mName=").append(mName);
        sb.append(", size=").append(size);
        sb.append(", url=").append(url);
        sb.append(", ctime=").append(ctime);
        sb.append(", remark=").append(remark);
        sb.append(", downNum=").append(downNum);
        sb.append("]");
        return sb.toString();
    }
}