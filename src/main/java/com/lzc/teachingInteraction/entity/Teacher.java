package com.lzc.teachingInteraction.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Teacher implements Serializable {
    @Id
    @Column(name = "t_id")
    private String tId;

    @Column(name = "u_id")
    private String uId;

    private static final long serialVersionUID = 1L;

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
        sb.append(", tId=").append(tId);
        sb.append(", uId=").append(uId);
        sb.append("]");
        return sb.toString();
    }
}