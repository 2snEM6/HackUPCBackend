package com.alife.Entity;

/**
 * Created by admin on 04/03/2017.
 */
public class Message {

    private String type;
    private String content;
    private String sentDate;

    public Message() {
    }

    public Message(String type, String content) {
        this.type = type;
        this.content = content;
    }

    public Message(String type, String content, String sentDate) {
        this.type = type;
        this.content = content;
        this.sentDate = sentDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSentDate() {
        return sentDate;
    }

    public void setSentDate(String sentDate) {
        this.sentDate = sentDate;
    }
}
