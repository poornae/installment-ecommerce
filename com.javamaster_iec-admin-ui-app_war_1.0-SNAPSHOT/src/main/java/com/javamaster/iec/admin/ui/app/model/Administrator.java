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
public class Administrator {

    private int adminID;
    private String username;
    private String password;
    private Timestamp created_at;
    private Timestamp updated_at;
    private Timestamp last_login_at;

    public Administrator(int adminID, String username, String password, Timestamp created_at, Timestamp updated_at, Timestamp last_login_at) {
        this.adminID = adminID;
        this.username = username;
        this.password = password;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.last_login_at = last_login_at;
    }

    public Administrator(String username, String password, Timestamp created_at, Timestamp updated_at, Timestamp last_login_at) {
        this.username = username;
        this.password = password;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.last_login_at = last_login_at;
    }

    public int getAdminID() {
        return adminID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
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

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
