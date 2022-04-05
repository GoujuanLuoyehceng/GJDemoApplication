package com.luobo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "stock_order")
public class OrderPO implements Serializable {
    @Id
    private long id;
    private int sid;
    @Column(name = "name")
    private String name;
    @Column(name = "create_time")
    private Timestamp createTime;
    private int uid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "OrderPO{" +
                "id=" + id +
                ", sid=" + sid +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", uid=" + uid +
                '}';
    }
}
