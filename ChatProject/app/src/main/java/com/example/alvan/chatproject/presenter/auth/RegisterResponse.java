package com.example.alvan.chatproject.presenter.auth;

/**
 * Created by David Bezalel Laoli on 10/21/2016.
 */
public interface RegisterResponse {
    public void doRegisterSuccess(String message);
    public void doRegisterFail(String message);
    public void doConnectionError(String message);
}
