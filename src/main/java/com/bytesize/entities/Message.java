package com.bytesize.entities;
import java.sql.Date;
import java.util.Objects;

public class Message {
    private int messageId, idFrom, idTo;
    private String message, nameFrom, title;
    private Date dateCreated;

    public Message(int messageId, int idFrom, int idTo, String message, String title) {
        this.messageId = messageId;
        this.idFrom = idFrom;
        this.idTo = idTo;
        this.message = message;
        this.title = title;
    }


    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getIdFrom() {
        return idFrom;
    }

    public void setIdFrom(int idFrom) {
        this.idFrom = idFrom;
    }

    public int getIdTo() {
        return idTo;
    }

    public void setIdTo(int idTo) {
        this.idTo = idTo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNameFrom() {
        return nameFrom;
    }

    public void setNameFrom(String nameFrom) {
        this.nameFrom = nameFrom;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        return messageId == message1.messageId && idFrom == message1.idFrom && idTo == message1.idTo && message.equals(message1.message) && nameFrom.equals(message1.nameFrom) && title.equals(message1.title) && dateCreated.equals(message1.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, idFrom, idTo, message, nameFrom, title, dateCreated);
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", idFrom=" + idFrom +
                ", idTo=" + idTo +
                ", message='" + message + '\'' +
                ", nameFrom='" + nameFrom + '\'' +
                ", title='" + title + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}