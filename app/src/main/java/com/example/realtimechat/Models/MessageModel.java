package com.example.realtimechat.Models;

public class MessageModel {
    String uId, message, messageId; String time;

    public MessageModel(String uId, String message, String time) {
        this.uId = uId;
        this.message = message;
        this.time = time;
    }



    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }


    public MessageModel(String uId, String message) {
        this.uId = uId;
        this.message = message;
    }                                 ////////////////////////////////////// for pushing in firebase
    public MessageModel(){

    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }



    public String getMessage() {
        return message;
    }   /// called for setting the text in text view

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
