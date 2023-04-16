/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author poornae
 */
public class User {

    private int userID;
    private String username;
    private String password;
    private String email;
    private int contact_no;
    private String role;
    private String permission;
    private Timestamp created_at;
    private int created_by;
    private Timestamp updated_at;
    private int updated_by;
    private Timestamp last_login_at;

    public User(int userID, String username, String password, String email, int contact_no, String role, String permission, Timestamp created_at, int created_by, Timestamp updated_at, int updated_by, Timestamp last_login_at) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.contact_no = contact_no;
        this.role = role;
        this.permission = permission;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.last_login_at = last_login_at;
    }

    public User(String username, String password, String email, int contact_no, String role, String permission, Timestamp created_at, int created_by, Timestamp updated_at, int updated_by, Timestamp last_login_at) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.contact_no = contact_no;
        this.role = role;
        this.permission = permission;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.last_login_at = last_login_at;
    }

    public int getUserID() {
        return userID;
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

    public int getContact_no() {
        return contact_no;
    }

    public String getRole() {
        return role;
    }

    public String getPermission() {
        return permission;
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

    public Timestamp getLast_login_at() {
        return last_login_at;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public void setContact_no(int contact_no) {
        this.contact_no = contact_no;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPermission(String permission) {
        this.permission = permission;
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

    public void setLast_login_at(Timestamp last_login_at) {
        this.last_login_at = last_login_at;
    }
}
