package com.example.alvan.chatproject.model.basic;

/**
 * Created by David Bezalel Laoli on 10/14/2016.
 */
public class Response {
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String message, code;
}
