package com.luobo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "stock")
public class StockPO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int count;
    private int sale;
    private int version;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "StockPO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", sale=" + sale +
                ", version=" + version +
                '}';
    }
}
