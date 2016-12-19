package com.example.alvan.chatproject.presenter;

import com.example.alvan.chatproject.model.responses.UserResponse;

/**
 * Created by David Bezalel Laoli on 10/30/2016.
 */
public interface iPresenterUserResponse extends iPresenterResponse {
    public void doSuccess(UserResponse userResponse);
}
