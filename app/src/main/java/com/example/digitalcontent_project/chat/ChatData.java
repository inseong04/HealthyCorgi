package com.example.digitalcontent_project.chat;

public class ChatData {
    private int chat_image;
    private String message;

    public int getChat_image() {
        return chat_image;
    }

    public void setChat_image(int chat_image) {
        this.chat_image = chat_image;
    }

    public ChatData(int chat_image) {
        this.chat_image = chat_image;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public ChatData(String message) {
        this.message = message;
    }
}
