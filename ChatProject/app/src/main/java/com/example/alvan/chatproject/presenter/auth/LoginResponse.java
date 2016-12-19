package com.example.alvan.chatproject.presenter.auth;

/**
 * Created by David Bezalel Laoli on 10/21/2016.
 */
public interface LoginResponse {
    public void doLoginSuccess(String message);
    public void doLoginFail(String message);
    public void doConnectionError(String message);
}
