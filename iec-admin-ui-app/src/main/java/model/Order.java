/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author poornae
 */
public class Order {

    private int orderID;
    private Date order_date;
    private Float order_total;
    private String order_status;
    private Timestamp updated_at;
    private int updated_by;
    private int customer_id; //foreign key
    private List<Transaction> transactions;

    public Order(int orderID, Date order_date, Float order_total, String order_status, Timestamp updated_at, int updated_by, int customer_id, List<Transaction> transactions) {
        this.orderID = orderID;
        this.order_date = order_date;
        this.order_total = order_total;
        this.order_status = order_status;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.customer_id = customer_id;
        this.transactions = transactions;
    }

    public Order(Date order_date, Float order_total, String order_status, Timestamp updated_at, int updated_by, int customer_id, List<Transaction> transactions) {
        this.order_date = order_date;
        this.order_total = order_total;
        this.order_status = order_status;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.customer_id = customer_id;
        this.transactions = transactions;
    }

    public int getOrderID() {
        return orderID;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public Float getOrder_total() {
        return order_total;
    }

    public String getOrder_status() {
        return order_status;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public int getUpdated_by() {
        return updated_by;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public void setOrder_total(Float order_total) {
        this.order_total = order_total;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public void setUpdated_by(int updated_by) {
        this.updated_by = updated_by;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
