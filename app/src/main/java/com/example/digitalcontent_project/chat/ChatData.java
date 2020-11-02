package com.example.digitalcontent_project.chat;

public class ChatData {

    private String user_message;
    private String viewtype;

    public String getViewtype() {
        return viewtype;
    }

    public void setViewtype(String viewtype) {
        this.viewtype = viewtype;
    }

    public ChatData(String user_message, String viewtype) {
        this.user_message = user_message;
        this.viewtype = viewtype;
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
