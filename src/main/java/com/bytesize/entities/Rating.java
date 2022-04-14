package com.bytesize.entities;

import java.util.Objects;

public class Rating {
    private int ratingId;
    private int rate;
    private String comment;
    private int buyerId;
    private int sellerId;

    public Rating() {}

    public Rating(int ratingId, int rate, String comment, int buyerId, int sellerId) {
        this.ratingId = ratingId;
        this.rate = rate;
        this.comment = comment;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
    }

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return ratingId == rating.ratingId && rate == rating.rate && buyerId == rating.buyerId && sellerId == rating.sellerId && Objects.equals(comment, rating.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ratingId, rate, comment, buyerId, sellerId);
    }

    @Override
    public String toString() {
        return "Rating{" +
                "ratingId=" + ratingId +
                ", rate=" + rate +
                ", comment='" + comment + '\'' +
                ", buyerId=" + buyerId +
                ", sellerId=" + sellerId +
                '}';
    }
}
