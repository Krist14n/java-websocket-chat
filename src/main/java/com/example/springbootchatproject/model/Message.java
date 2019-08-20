package com.example.springbootchatproject.model;
/**
 * WebSocket message model
 */
public class Message {

    private String from;
    private String to;
    private String content;
    private String type;
    private Integer count;

    public Message() { }

    public Message(String from, String to, String content, String type, Integer count) {
        this.from = from;
        this.to = to;
        this.content = content;
        this.type = type;
        this.count = count;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
