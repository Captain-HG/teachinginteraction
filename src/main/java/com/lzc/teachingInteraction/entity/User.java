package com.lzc.teachingInteraction.entity;

import java.io.Serializable;
import javax.persistence.*;

public class User implements Serializable {
    @Id
    @Column(name = "u_id")
    private String uId;

    private String account;

    @Column(name = "u_name")
    private String uName;

    private String password;

    private Byte type;

    private Byte sex;

    private Byte state;

    @Column(name = "cTime")
    private Integer ctime;

    @Column(name = "onTime")
    private Integer ontime;

    @Column(name = "headImg")
    private String headimg;

    private String detail;

    private String remark;

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
     * @return account
     */
    public String getAccount() {
        return account;
    }

    /**
     * @param account
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * @return u_name
     */
    public String getuName() {
        return uName;
    }

    /**
     * @param uName
     */
    public void setuName(String uName) {
        this.uName = uName;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
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

    /**
     * @return sex
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(Byte sex) {
        this.sex = sex;
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
     * @return onTime
     */
    public Integer getOntime() {
        return ontime;
    }

    /**
     * @param ontime
     */
    public void setOntime(Integer ontime) {
        this.ontime = ontime;
    }

    /**
     * @return headImg
     */
    public String getHeadimg() {
        return headimg;
    }

    /**
     * @param headimg
     */
    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    /**
     * @return detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     * @param detail
     */
    public void setDetail(String detail) {
        this.detail = detail;
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
        sb.append(", uId=").append(uId);
        sb.append(", account=").append(account);
        sb.append(", uName=").append(uName);
        sb.append(", password=").append(password);
        sb.append(", type=").append(type);
        sb.append(", sex=").append(sex);
        sb.append(", state=").append(state);
        sb.append(", ctime=").append(ctime);
        sb.append(", ontime=").append(ontime);
        sb.append(", headimg=").append(headimg);
        sb.append(", detail=").append(detail);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}