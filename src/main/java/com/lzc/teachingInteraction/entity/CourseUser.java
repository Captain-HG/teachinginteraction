package com.lzc.teachingInteraction.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "course_user")
public class CourseUser implements Serializable {
    @Id
    @Column(name = "c_id")
    private String cId;

    @Id
    @Column(name = "u_id")
    private String uId;

    @Column(name = "cTime")
    private Integer ctime;

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
        sb.append(", cId=").append(cId);
        sb.append(", uId=").append(uId);
        sb.append(", ctime=").append(ctime);
        sb.append("]");
        return sb.toString();
    }
}