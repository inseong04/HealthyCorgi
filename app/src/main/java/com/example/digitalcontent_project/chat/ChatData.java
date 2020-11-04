package com.example.digitalcontent_project.chat;

public class ChatData {

    private String user_message;
    private int viewType;

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public ChatData(String user_message, int viewType) {
        this.user_message = user_message;
        this.viewType = viewType;
    }

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
