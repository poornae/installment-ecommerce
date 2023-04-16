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
public class Customer {

    private int customerID;
    private String full_name;
    private String username;
    private String password;
    private String email;
    private Date date_of_birth;
    private String nic_no;
    private byte[] profile_image;
    private int contact_no;
    private String address;
    private Timestamp created_at;
    private Timestamp updated_at;
    private Timestamp last_login_at;
    private List<Loan> customers;
    private List<Order> orders;
    private List<Transaction> transactions;

    public Customer(int customerID, String full_name, String username, String password, String email, Date date_of_birth, String nic_no, byte[] profile_image, int contact_no, String address, Timestamp created_at, Timestamp updated_at, Timestamp last_login_at, List<Loan> customers, List<Order> orders, List<Transaction> transactions) {
        this.customerID = customerID;
        this.full_name = full_name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.date_of_birth = date_of_birth;
        this.nic_no = nic_no;
        this.profile_image = profile_image;
        this.contact_no = contact_no;
        this.address = address;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.last_login_at = last_login_at;
        this.customers = customers;
        this.orders = orders;
        this.transactions = transactions;
    }

    public Customer(String full_name, String username, String password, String email, Date date_of_birth, String nic_no, byte[] profile_image, int contact_no, String address, Timestamp created_at, Timestamp updated_at, Timestamp last_login_at, List<Loan> customers, List<Order> orders, List<Transaction> transactions) {
        this.full_name = full_name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.date_of_birth = date_of_birth;
        this.nic_no = nic_no;
        this.profile_image = profile_image;
        this.contact_no = contact_no;
        this.address = address;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.last_login_at = last_login_at;
        this.customers = customers;
        this.orders = orders;
        this.transactions = transactions;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public String getNic_no() {
        return nic_no;
    }

    public byte[] getProfile_image() {
        return profile_image;
    }

    public int getContact_no() {
        return contact_no;
    }

    public String getAddress() {
        return address;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public Timestamp getLast_login_at() {
        return last_login_at;
    }

    public List<Loan> getCustomers() {
        return customers;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void setNic_no(String nic_no) {
        this.nic_no = nic_no;
    }

    public void setProfile_image(byte[] profile_image) {
        this.profile_image = profile_image;
    }

    public void setContact_no(int contact_no) {
        this.contact_no = contact_no;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public void setLast_login_at(Timestamp last_login_at) {
        this.last_login_at = last_login_at;
    }

    public void setCustomers(List<Loan> customers) {
        this.customers = customers;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

}
