/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tables;

/**
 *
 * @author poornae
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class Customer {
    private String customerId;
    private String fullName;
    private String email;
    private String dob;
    private String nicNo;
    private String profileImage;
    private String contactNo;
    private String address;
    private String createdAt;
    private String updatedAt;
    private String loginAt;


    public Customer() {
        this.customerId = "";
        this.fullName = "";
        this.email = "";
        this.dob = "";
        this.nicNo = "";
        this.profileImage = "";
        this.contactNo = "";
        this.address = "";
        this.createdAt = "";
        this.updatedAt = "";
        this.loginAt = "";
    }

    public Customer(String customerId, String fullName, String email, String dob, String nicNo, String profileImage, String contactNo, String address, String createdAt, String updatedAt, String loginAt) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.email = email;
        this.dob = dob;
        this.nicNo = nicNo;
        this.profileImage = profileImage;
        this.contactNo = contactNo;
        this.address = address;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.loginAt = loginAt;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setLoginAt(String loginAt) {
        this.loginAt = loginAt;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getDob() {
        return dob;
    }

    public String getNicNo() {
        return nicNo;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getAddress() {
        return address;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getLoginAt() {
        return loginAt;
    }

    public String getCustomerId() {
        return customerId;
    }
}
