package com.lzc.teachingInteraction.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Course implements Serializable {
    @Id
    @Column(name = "c_id")
    private String cId;

    @Column(name = "t_id")
    private String tId;

    @Column(name = "c_name")
    private String cName;

    private String detail;

    @Column(name = "cTime")
    private Integer ctime;

    @Column(name = "uTime")
    private Integer utime;

    private Integer chance;

    @Column(name = "c_logoUrl")
    private String cLogourl;

    private static final long serialVersionUID = 1L;

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
     * @return c_name
     */
    public String getcName() {
        return cName;
    }

    /**
     * @param cName
     */
    public void setcName(String cName) {
        this.cName = cName;
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
     * @return chance
     */
    public Integer getChance() {
        return chance;
    }

    /**
     * @param chance
     */
    public void setChance(Integer chance) {
        this.chance = chance;
    }

    /**
     * @return c_logoUrl
     */
    public String getcLogourl() {
        return cLogourl;
    }

    /**
     * @param cLogourl
     */
    public void setcLogourl(String cLogourl) {
        this.cLogourl = cLogourl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cId=").append(cId);
        sb.append(", tId=").append(tId);
        sb.append(", cName=").append(cName);
        sb.append(", detail=").append(detail);
        sb.append(", ctime=").append(ctime);
        sb.append(", utime=").append(utime);
        sb.append(", chance=").append(chance);
        sb.append(", cLogourl=").append(cLogourl);
        sb.append("]");
        return sb.toString();
    }
}