/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javamaster.iec.admin.ui.app.model;

import java.sql.Timestamp;

/**
 *
 * @author poornae
 */
public class Inventory {

    private int inventoryID;
    private String name;
    private String type;
    private int available_quantity;
    private Boolean[] availability_status;
    private Float unit_cost_price;
    private Float unit_selling_price;
    private Timestamp created_at;
    private int created_by;
    private Timestamp updated_at;
    private int updated_by;
    private int product_id; //foreign key

    public Inventory(int inventoryID, String name, String type, int available_quantity, Boolean[] availability_status, Float unit_cost_price, Float unit_selling_price, Timestamp created_at, int created_by, Timestamp updated_at, int updated_by, int product_id) {
        this.inventoryID = inventoryID;
        this.name = name;
        this.type = type;
        this.available_quantity = available_quantity;
        this.availability_status = availability_status;
        this.unit_cost_price = unit_cost_price;
        this.unit_selling_price = unit_selling_price;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.product_id = product_id;
    }

    public Inventory(String name, String type, int available_quantity, Boolean[] availability_status, Float unit_cost_price, Float unit_selling_price, Timestamp created_at, int created_by, Timestamp updated_at, int updated_by, int product_id) {
        this.name = name;
        this.type = type;
        this.available_quantity = available_quantity;
        this.availability_status = availability_status;
        this.unit_cost_price = unit_cost_price;
        this.unit_selling_price = unit_selling_price;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.product_id = product_id;
    }

    public int getInventoryID() {
        return inventoryID;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getAvailable_quantity() {
        return available_quantity;
    }

    public Boolean[] getAvailability_status() {
        return availability_status;
    }

    public Float getUnit_cost_price() {
        return unit_cost_price;
    }

    public Float getUnit_selling_price() {
        return unit_selling_price;
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

    public int getProduct_id() {
        return product_id;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAvailable_quantity(int available_quantity) {
        this.available_quantity = available_quantity;
    }

    public void setAvailability_status(Boolean[] availability_status) {
        this.availability_status = availability_status;
    }

    public void setUnit_cost_price(Float unit_cost_price) {
        this.unit_cost_price = unit_cost_price;
    }

    public void setUnit_selling_price(Float unit_selling_price) {
        this.unit_selling_price = unit_selling_price;
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

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    
}
