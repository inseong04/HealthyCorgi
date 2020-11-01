package com.example.digitalcontent_project.chat;

public class ChatData {

    private String user_message;

    public String getUser_message() {
        return user_message;
    }

    public void setUser_message(String user_message) {
        this.user_message = user_message;
    }

    public ChatData(String user_message) {
        this.user_message = user_message;
    }
}
