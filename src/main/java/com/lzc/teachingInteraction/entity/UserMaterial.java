package com.lzc.teachingInteraction.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "user_material")
public class UserMaterial implements Serializable {
    @Id
    @Column(name = "u_id")
    private String uId;

    @Id
    @Column(name = "m_id")
    private String mId;

    @Column(name = "cTime")
    private Integer ctime;

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
        sb.append(", uId=").append(uId);
        sb.append(", mId=").append(mId);
        sb.append(", ctime=").append(ctime);
        sb.append("]");
        return sb.toString();
    }
}