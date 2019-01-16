package com.lzc.teachingInteraction.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Admin implements Serializable {
    @Id
    @Column(name = "a_id")
    private String aId;

    @Column(name = "u_id")
    private String uId;

    private static final long serialVersionUID = 1L;

    /**
     * @return a_id
     */
    public String getaId() {
        return aId;
    }

    /**
     * @param aId
     */
    public void setaId(String aId) {
        this.aId = aId;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", aId=").append(aId);
        sb.append(", uId=").append(uId);
        sb.append("]");
        return sb.toString();
    }
}