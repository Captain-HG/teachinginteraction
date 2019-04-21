package com.lzc.teachingInteraction.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Advise implements Serializable {
    @Id
    @Column(name = "ad_id")
    private String adId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "ad_name")
    private String adName;

    @Column(name = "ad_email")
    private String adEmail;

    private String remark;

    private String message;

    @Column(name = "cTime")
    private Integer ctime;

    private Byte state;

    private static final long serialVersionUID = 1L;

    /**
     * @return ad_id
     */
    public String getAdId() {
        return adId;
    }

    /**
     * @param adId
     */
    public void setAdId(String adId) {
        this.adId = adId;
    }

    /**
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return ad_name
     */
    public String getAdName() {
        return adName;
    }

    /**
     * @param adName
     */
    public void setAdName(String adName) {
        this.adName = adName;
    }

    /**
     * @return ad_email
     */
    public String getAdEmail() {
        return adEmail;
    }

    /**
     * @param adEmail
     */
    public void setAdEmail(String adEmail) {
        this.adEmail = adEmail;
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
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adId=").append(adId);
        sb.append(", userId=").append(userId);
        sb.append(", adName=").append(adName);
        sb.append(", adEmail=").append(adEmail);
        sb.append(", remark=").append(remark);
        sb.append(", message=").append(message);
        sb.append(", ctime=").append(ctime);
        sb.append(", state=").append(state);
        sb.append("]");
        return sb.toString();
    }
}