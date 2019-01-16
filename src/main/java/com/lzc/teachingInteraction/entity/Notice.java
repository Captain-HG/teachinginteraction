package com.lzc.teachingInteraction.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Notice implements Serializable {
    @Id
    @Column(name = "n_id")
    private String nId;

    @Column(name = "a_id")
    private String aId;

    private String title;

    @Column(name = "sub_text")
    private String subText;

    @Column(name = "cTime")
    private Integer ctime;

    private Byte state;

    private static final long serialVersionUID = 1L;

    /**
     * @return n_id
     */
    public String getnId() {
        return nId;
    }

    /**
     * @param nId
     */
    public void setnId(String nId) {
        this.nId = nId;
    }

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
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return sub_text
     */
    public String getSubText() {
        return subText;
    }

    /**
     * @param subText
     */
    public void setSubText(String subText) {
        this.subText = subText;
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
        sb.append(", nId=").append(nId);
        sb.append(", aId=").append(aId);
        sb.append(", title=").append(title);
        sb.append(", subText=").append(subText);
        sb.append(", ctime=").append(ctime);
        sb.append(", state=").append(state);
        sb.append("]");
        return sb.toString();
    }
}