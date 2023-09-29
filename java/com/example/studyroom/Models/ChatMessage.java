package com.example.studyroom.Models;

public class ChatMessage {
    private String id;
    private String text;
    private String fromId;
    private String toId;
    private long timestamp;

    public ChatMessage() {
        this.id = "";
        this.text = "";
        this.fromId = "";
        this.toId = "";
        this.timestamp = -1;
    }

    public ChatMessage(String id, String text, String fromId, String toId, long timestamp) {
        this.id = id;
        this.text = text;
        this.fromId = fromId;
        this.toId = toId;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
