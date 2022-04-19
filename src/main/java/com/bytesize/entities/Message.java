package com.bytesize.entities;

import java.sql.Date;
import java.util.Objects;

public class Message {
    private int messageId, userId, userIdTo;
    private String message, userNameFrom;
    private Date date;

    public Message(int messageId, int userId, int userIdTo, String message, String userNameFrom) {
        this.messageId = messageId;
        this.userId = userId;
        this.userIdTo = userIdTo;
        this.message = message;
        this.userNameFrom = userNameFrom;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserIdTo() {
        return userIdTo;
    }

    public void setUserIdTo(int userIdTo) {
        this.userIdTo = userIdTo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserNameFrom() {
        return userNameFrom;
    }

    public void setUserNameFrom(String userNameFrom) {
        this.userNameFrom = userNameFrom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message1 = (Message) o;
        return messageId == message1.messageId && userId == message1.userId && userIdTo == message1.userIdTo && message.equals(message1.message) && userNameFrom.equals(message1.userNameFrom) && date.equals(message1.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, userId, userIdTo, message, userNameFrom, date);
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", userId=" + userId +
                ", userIdTo=" + userIdTo +
                ", message='" + message + '\'' +
                ", userNameFrom='" + userNameFrom + '\'' +
                ", date=" + date +
                '}';
    }
}