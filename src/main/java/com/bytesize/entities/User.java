package com.bytesize.entities;

import java.util.Objects;

public class User {
    private int userId;
    private String username;
    private String password;
    private boolean isBuyer;
    private boolean isSeller;

    public User(){}

    public User(int userId, String username, String password, boolean isBuyer, boolean isSeller){
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.isBuyer = isBuyer;
        this.isSeller = isSeller;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public void setBuyer(boolean buyer) {
        isBuyer = buyer;
    }

    public void setSeller(boolean seller) {
        isSeller = seller;
    }

    public boolean isBuyer() {
        return isBuyer;
    }

    public boolean isSeller() {
        return isSeller;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && isBuyer == user.isBuyer && isSeller == user.isSeller && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, password, isBuyer, isSeller);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isBuyer=" + isBuyer +
                ", isSeller=" + isSeller +
                '}';
    }
}
