package com.sample.sfms.model.user;

import java.sql.Date;

public class SaveUserModel {
    private int id;
    private String username;
    private String password;
    private int roleByRoleId;
    private int majorByMajorId;
    private int departmentByDepartmentId;
    private String mail;
    private boolean male;
    private boolean status;
    private String fullname;
    private Date birth;
    private String code;
    private String confirmPassword;

    public SaveUserModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(int roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }

    public int getMajorByMajorId() {
        return majorByMajorId;
    }

    public void setMajorByMajorId(int majorByMajorId) {
        this.majorByMajorId = majorByMajorId;
    }

    public int getDepartmentByDepartmentId() {
        return departmentByDepartmentId;
    }

    public void setDepartmentByDepartmentId(int departmentByDepartmentId) {
        this.departmentByDepartmentId = departmentByDepartmentId;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
