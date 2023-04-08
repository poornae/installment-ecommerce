/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javamaster.iec.admin.ui.app.model;

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
    private String date_of_birth;
    private String nic_no;
    private String profile_image;
    private String contact_no;
    private String address;
    private String created_at;
    private String updated_at;
    private String last_login_at;

    public Customer(int customerID, String full_name, String username, String password, String email, String date_of_birth, String nic_no, String profile_image, String contact_no, String address, String created_at, String updated_at, String last_login_at) {
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
    }

    public Customer(String full_name, String username, String password, String email, String date_of_birth, String nic_no, String profile_image, String contact_no, String address, String created_at, String updated_at, String last_login_at) {
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
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getNic_no() {
        return nic_no;
    }

    public void setNic_no(String nic_no) {
        this.nic_no = nic_no;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getLast_login_at() {
        return last_login_at;
    }

    public void setLast_login_at(String last_login_at) {
        this.last_login_at = last_login_at;
    }
}
