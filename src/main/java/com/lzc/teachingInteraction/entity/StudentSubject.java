package com.lzc.teachingInteraction.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "student_subject")
public class StudentSubject implements Serializable {
    @Id
    @Column(name = "s_id")
    private String sId;

    @Id
    @Column(name = "sub_id")
    private String subId;

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
     * @return sub_id
     */
    public String getSubId() {
        return subId;
    }

    /**
     * @param subId
     */
    public void setSubId(String subId) {
        this.subId = subId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sId=").append(sId);
        sb.append(", subId=").append(subId);
        sb.append("]");
        return sb.toString();
    }
}