package com.cdu.springboot.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 商品对象
 */
@Entity
@Table(name = "tb_article")
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String supplier;
    private Double price;
    private String locality;
    private Date putawayDate;
    private int storage;
    private String image;
    private String description;
    private Date createDate;

    public Article() {
    }

    public Article(String title, String supplier, Double price, String locality, Date putawayDate, int storage, String image, String description, Date creatDate) {
        this.title = title;
        this.supplier = supplier;
        this.price = price;
        this.locality = locality;
        this.putawayDate = putawayDate;
        this.storage = storage;
        this.image = image;
        this.description = description;
        this.createDate = creatDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public Date getPutawayDate() {
        return putawayDate;
    }

    public void setPutawayDate(Date putawayDate) {
        this.putawayDate = putawayDate;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatDate() {
        return createDate;
    }

    public void setCreatDate(Date creatDate) {
        this.createDate = creatDate;
    }
}
