package com.example.alvan.chatproject.model.responses;

import com.example.alvan.chatproject.model.basic.Response;
import com.example.alvan.chatproject.model.basic.User;

/**
 * Created by David Bezalel Laoli on 10/14/2016.
 */
public class UserResponse extends Response {
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;
}
