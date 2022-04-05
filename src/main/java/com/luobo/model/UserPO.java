package com.luobo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity
@Table(name = "user")
public class UserPO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String uid;
    @Column(name = "nickname")
    private String nickName;
    private String portrait;
    @Column(name = "phone")
    private String phoneNumber;
    private String mail;
    @Column(name = "openid")
    private String openId;
    @Column(name = "create_time")
    private Timestamp createTime;

    public UserPO() {
    }

    public UserPO(long id, String uid, String nickName, String portrait, String phoneNumber, String mail, String openId, Timestamp createTime) {
        this.id = id;
        this.uid = uid;
        this.nickName = nickName;
        this.portrait = portrait;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.openId = openId;
        this.createTime = createTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserPO{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", nickName='" + nickName + '\'' +
                ", portrait='" + portrait + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", mail='" + mail + '\'' +
                ", openId='" + openId + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
