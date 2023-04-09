/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javamaster.iec.admin.ui.app.model;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author poornae
 */
public class Product {

    private int productID;
    private String name;
    private String description;
    private Byte[] image;
    private Float original_price;
    private Float discount;
    private Float discounted_price;
    private Timestamp created_at;
    private int created_by;
    private Timestamp updated_at;
    private int updated_by;
    private int category_id; //foreign key
    private int brand_id; //foreign key
    private List<Inventory> inventories;

    public Product(int productID, String name, String description, Byte[] image, Float original_price, Float discount, Float discounted_price, Timestamp created_at, int created_by, Timestamp updated_at, int updated_by, int category_id, int brand_id, List<Inventory> inventories) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.image = image;
        this.original_price = original_price;
        this.discount = discount;
        this.discounted_price = discounted_price;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.category_id = category_id;
        this.brand_id = brand_id;
        this.inventories = inventories;
    }

    public Product(String name, String description, Byte[] image, Float original_price, Float discount, Float discounted_price, Timestamp created_at, int created_by, Timestamp updated_at, int updated_by, int category_id, int brand_id, List<Inventory> inventories) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.original_price = original_price;
        this.discount = discount;
        this.discounted_price = discounted_price;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.category_id = category_id;
        this.brand_id = brand_id;
        this.inventories = inventories;
    }

    public int getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Byte[] getImage() {
        return image;
    }

    public Float getOriginal_price() {
        return original_price;
    }

    public Float getDiscount() {
        return discount;
    }

    public Float getDiscounted_price() {
        return discounted_price;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public int getCreated_by() {
        return created_by;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public int getUpdated_by() {
        return updated_by;
    }

    public int getCategory_id() {
        return category_id;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public void setOriginal_price(Float original_price) {
        this.original_price = original_price;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public void setDiscounted_price(Float discounted_price) {
        this.discounted_price = discounted_price;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public void setUpdated_by(int updated_by) {
        this.updated_by = updated_by;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }
}
