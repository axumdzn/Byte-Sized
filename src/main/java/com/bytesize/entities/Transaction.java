package com.bytesize.entities;

import java.util.Objects;

public class Transaction {
    private int transactionId;
    private int amount;
    private String size;
    private String status;
    private int productId;
    private int buyerId;

    public Transaction() {}

    public Transaction(int transactionId, int amount, String size, String status, int productId, int buyerId) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.size = size;
        this.status = status;
        this.productId = productId;
        this.buyerId = buyerId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return transactionId == that.transactionId && amount == that.amount && productId == that.productId && buyerId == that.buyerId && Objects.equals(size, that.size) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, amount, size, status, productId, buyerId);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", amount=" + amount +
                ", size='" + size + '\'' +
                ", status='" + status + '\'' +
                ", productId=" + productId +
                ", buyerId=" + buyerId +
                '}';
    }
}
