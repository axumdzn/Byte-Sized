package com.bytesize.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Message {
    private int messageId;
    private String message;
    private int buyerId;
    private int sellerId;
    private int senderId;
//    needs to be put in an actual date, but I need to find the correct package
    private LocalDate date;

    public Message() {}

    public Message(int messageId, String message, int buyerId, int sellerId, int senderId, LocalDate date) {
        this.messageId = messageId;
        this.message = message;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.senderId = senderId;
        this.date = date;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message1 = (Message) o;
        return messageId == message1.messageId && buyerId == message1.buyerId && sellerId == message1.sellerId && senderId == message1.senderId && Objects.equals(message, message1.message) && Objects.equals(date, message1.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, message, buyerId, sellerId, senderId, date);
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", message='" + message + '\'' +
                ", buyerId=" + buyerId +
                ", sellerId=" + sellerId +
                ", senderId=" + senderId +
                ", date=" + date +
                '}';
    }
}
