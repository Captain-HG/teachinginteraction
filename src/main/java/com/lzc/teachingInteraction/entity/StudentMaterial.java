package com.lzc.teachingInteraction.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "student_material")
public class StudentMaterial implements Serializable {
    @Id
    @Column(name = "s_id")
    private String sId;

    @Id
    @Column(name = "m_id")
    private String mId;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sId=").append(sId);
        sb.append(", mId=").append(mId);
        sb.append("]");
        return sb.toString();
    }
}