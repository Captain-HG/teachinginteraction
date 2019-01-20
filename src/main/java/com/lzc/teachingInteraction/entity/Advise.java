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
        sb.append("]");
        return sb.toString();
    }
}