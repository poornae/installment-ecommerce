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
public class Category {

    private int categoryID;
    private String name;
    private Timestamp created_at;
    private int created_by;
    private Timestamp updated_at;
    private int updated_by;
    private List<Product> products;

    public Category(int categoryID, String name, Timestamp created_at, int created_by, Timestamp updated_at, int updated_by, List<Product> products) {
        this.categoryID = categoryID;
        this.name = name;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.products = products;
    }

    public Category(String name, Timestamp created_at, int created_by, Timestamp updated_at, int updated_by, List<Product> products) {
        this.name = name;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.products = products;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public String getName() {
        return name;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
