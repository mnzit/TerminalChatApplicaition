/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.terminalchatapplication.entity;

import java.util.Date;

/**
 *
 * @author Mnzit
 */
public class User {

    private int id;
    private String userName, password;
    private Date joinDate;
    private boolean status;
    private double balance;

    public User() {
    }

    public User(int id, String userName, String password, Date joinDate, boolean status, double balance) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.joinDate = joinDate;
        this.status = status;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
