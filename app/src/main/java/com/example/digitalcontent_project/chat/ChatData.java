package com.example.digitalcontent_project.chat;

public class ChatData {

    private String user_input;

    public String getUser_input() {
        return user_input;
    }

    public void setUser_input(String user_input) {
        this.user_input = user_input;
    }

    public ChatData(String user_input) {
        this.user_input = user_input;
    }
}
