package com.chen;

import java.sql.SQLOutput;

/**
 * @auther chen
 * @creath 2020-08-02 19:33
 */
public class User {
    private String cardNo;
    private String identity;
    private String userNname;
    private String password;
    private String phone;
    private double balance;

    public User() {
    }

    public User(String cardNo, String identity, String userNname, String password, String phone, double balance) {
        this.cardNo = cardNo;
        this.identity = identity;
        this.userNname = userNname;
        this.password = password;
        this.phone = phone;
        this.balance = balance;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getUserNname() {
        return userNname;
    }

    public void setUserNname(String userNname) {
        this.userNname = userNname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
