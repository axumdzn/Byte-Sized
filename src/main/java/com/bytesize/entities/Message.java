package com.bytesize.entities;
import java.sql.Date;
import java.util.Objects;

public class Message {
    private int messageId, buyerId, sellerId, senderId;
    private String message;
    private Date dateCreated;

    public Message(int messageId, int buyerId, int sellerId, int senderId, String message) {
        this.messageId = messageId;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.senderId = senderId;
        this.message = message;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message1 = (Message) o;
        return messageId == message1.messageId && buyerId == message1.buyerId && sellerId == message1.sellerId && senderId == message1.senderId && message.equals(message1.message) && dateCreated.equals(message1.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, buyerId, sellerId, senderId, message, dateCreated);
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", buyerId=" + buyerId +
                ", sellerId=" + sellerId +
                ", senderId=" + senderId +
                ", message='" + message + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}