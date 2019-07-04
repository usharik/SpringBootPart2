package ru.geekmarket.chatbot.controller;

import java.time.LocalDateTime;

public class ChatMessage {

    private String username;

    private String message;

    private LocalDateTime localDateTime;

    public ChatMessage() {
        this.localDateTime = LocalDateTime.now();
    }

    public ChatMessage(String username, String message) {
        this.username = username;
        this.message = message;
        this.localDateTime = LocalDateTime.now();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
