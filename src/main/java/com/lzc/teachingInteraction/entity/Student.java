package com.lzc.teachingInteraction.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Student implements Serializable {
    @Id
    @Column(name = "s_id")
    private String sId;

    @Column(name = "u_id")
    private String uId;

    @Column(name = "s_grade")
    private String sGrade;

    @Column(name = "school_name")
    private String schoolName;

    private Byte state;

    private static final long serialVersionUID = 1L;

    /**
     * @return s_id
     */
    public String getsId() {
        return sId;
    }

    /**
     * @param sId
     */
    public void setsId(String sId) {
        this.sId = sId;
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
     * @return s_grade
     */
    public String getsGrade() {
        return sGrade;
    }

    /**
     * @param sGrade
     */
    public void setsGrade(String sGrade) {
        this.sGrade = sGrade;
    }

    /**
     * @return school_name
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * @param schoolName
     */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
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
        sb.append(", sId=").append(sId);
        sb.append(", uId=").append(uId);
        sb.append(", sGrade=").append(sGrade);
        sb.append(", schoolName=").append(schoolName);
        sb.append(", state=").append(state);
        sb.append("]");
        return sb.toString();
    }
}