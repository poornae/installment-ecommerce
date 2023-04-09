/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javamaster.iec.admin.ui.app.model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author poornae
 */
public class Transaction {

    private int transactionID;
    private Date transaction_date;
    private Float transaction_amount;
    private String payment_method;
    private String payment_status;
    private String promo_code;
    private Timestamp updated_at;
    private int updated_by;
    private int customer_id; //foreign key
    private int loan_id; //foreign key
    private int order_id; //foreign key

    public Transaction(int transactionID, Date transaction_date, Float transaction_amount, String payment_method, String payment_status, String promo_code, Timestamp updated_at, int updated_by, int customer_id, int loan_id, int order_id) {
        this.transactionID = transactionID;
        this.transaction_date = transaction_date;
        this.transaction_amount = transaction_amount;
        this.payment_method = payment_method;
        this.payment_status = payment_status;
        this.promo_code = promo_code;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.customer_id = customer_id;
        this.loan_id = loan_id;
        this.order_id = order_id;
    }

    public Transaction(Date transaction_date, Float transaction_amount, String payment_method, String payment_status, String promo_code, Timestamp updated_at, int updated_by, int customer_id, int loan_id, int order_id) {
        this.transaction_date = transaction_date;
        this.transaction_amount = transaction_amount;
        this.payment_method = payment_method;
        this.payment_status = payment_status;
        this.promo_code = promo_code;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.customer_id = customer_id;
        this.loan_id = loan_id;
        this.order_id = order_id;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public Date getTransaction_date() {
        return transaction_date;
    }

    public Float getTransaction_amount() {
        return transaction_amount;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public String getPromo_code() {
        return promo_code;
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

    public int getLoan_id() {
        return loan_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public void setTransaction_date(Date transaction_date) {
        this.transaction_date = transaction_date;
    }

    public void setTransaction_amount(Float transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

    public void setPromo_code(String promo_code) {
        this.promo_code = promo_code;
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

    public void setLoan_id(int loan_id) {
        this.loan_id = loan_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
}
