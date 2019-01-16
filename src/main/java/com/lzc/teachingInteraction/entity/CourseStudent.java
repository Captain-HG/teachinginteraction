package com.lzc.teachingInteraction.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "course_student")
public class CourseStudent implements Serializable {
    @Id
    @Column(name = "c_id")
    private String cId;

    @Id
    @Column(name = "s_id")
    private String sId;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cId=").append(cId);
        sb.append(", sId=").append(sId);
        sb.append("]");
        return sb.toString();
    }
}