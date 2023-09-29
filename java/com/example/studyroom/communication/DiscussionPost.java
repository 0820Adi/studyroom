package com.example.studyroom.communication;

public class DiscussionPost {
    private String username; // Username of the post author
    private String content;  // Content of the post

    public DiscussionPost(String username, String content) {
        this.username = username;
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public String getContent() {
        return content;
    }
}
