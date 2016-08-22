package com.xapp.jjh.xlog.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Taurus on 2016/5/26.
 */
public class Product implements Serializable {
    private int id;
    private String pName;
    private double price;
    private List<ProductImage> images;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<ProductImage> getImages() {
        return images;
    }

    public void setImages(List<ProductImage> images) {
        this.images = images;
    }
}
