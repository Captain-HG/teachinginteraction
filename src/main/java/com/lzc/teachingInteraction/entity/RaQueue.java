package com.lzc.teachingInteraction.entity;

import java.io.Serializable;
import javax.persistence.*;

public class RaQueue implements Serializable {
    @Id
    @Column(name = "q_id")
    private String qId;

    @Column(name = "queue_name")
    private String queueName;

    private Byte state;

    private String remark;

    @Column(name = "to_uId")
    private String toUid;

    @Column(name = "from_uid")
    private String fromUid;

    @Column(name = "cTime")
    private Integer ctime;

    private static final long serialVersionUID = 1L;

    /**
     * @return q_id
     */
    public String getqId() {
        return qId;
    }

    /**
     * @param qId
     */
    public void setqId(String qId) {
        this.qId = qId;
    }

    /**
     * @return queue_name
     */
    public String getQueueName() {
        return queueName;
    }

    /**
     * @param queueName
     */
    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    /**
     * @return state
     */
    public Byte getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(Byte state) {
        this.state = state;
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
     * @return to_uId
     */
    public String getToUid() {
        return toUid;
    }

    /**
     * @param toUid
     */
    public void setToUid(String toUid) {
        this.toUid = toUid;
    }

    /**
     * @return from_uid
     */
    public String getFromUid() {
        return fromUid;
    }

    /**
     * @param fromUid
     */
    public void setFromUid(String fromUid) {
        this.fromUid = fromUid;
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
        sb.append(", qId=").append(qId);
        sb.append(", queueName=").append(queueName);
        sb.append(", state=").append(state);
        sb.append(", remark=").append(remark);
        sb.append(", toUid=").append(toUid);
        sb.append(", fromUid=").append(fromUid);
        sb.append(", ctime=").append(ctime);
        sb.append("]");
        return sb.toString();
    }
}