package com.lzc.teachingInteraction.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Admin implements Serializable {
    @Id
    @Column(name = "a_id")
    private String aId;

    @Column(name = "u_id")
    private String uId;

    private Byte state;

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
        sb.append(", aId=").append(aId);
        sb.append(", uId=").append(uId);
        sb.append(", state=").append(state);
        sb.append("]");
        return sb.toString();
    }
}