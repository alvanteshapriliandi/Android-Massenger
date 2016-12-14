package com.example.alvan.chatproject;

/**
 * Created by alvan on 13/12/16.
 */

public class LoginAPI {

    private final String USERNAME = "Kelompok";
    private final String PASSWORD = "Kelompok";

    public boolean authenticate (String username, String password)
    {
        if(USERNAME.equals(username) && PASSWORD.equals(password))
        {
            return true;
        }
        return false;
    }
}
