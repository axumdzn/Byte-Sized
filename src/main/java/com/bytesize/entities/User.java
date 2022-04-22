package com.bytesize.entities;

import java.util.Objects;

public class User {
    private int userId;
    private String userName;
    private String passWord;
    private boolean isBuyer;
    private boolean isSeller;

    public User(int userId, String userName, String passWord, boolean isBuyer, boolean isSeller) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.isBuyer = isBuyer;
        this.isSeller = isSeller;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public boolean isBuyer() {
        return isBuyer;
    }

    public void setBuyer(boolean buyer) {
        isBuyer = buyer;
    }

    public boolean isSeller() {
        return isSeller;
    }

    public void setSeller(boolean seller) {
        isSeller = seller;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && isBuyer == user.isBuyer && isSeller == user.isSeller && userName.equals(user.userName) && passWord.equals(user.passWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, passWord, isBuyer, isSeller);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", isBuyer=" + isBuyer +
                ", isSeller=" + isSeller +
                '}';
    }
}
