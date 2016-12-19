package com.example.alvan.chatproject.presenter.auth;

import android.content.Context;

import com.example.alvan.chatproject.model.connections.ConnectionAPI;
import com.example.alvan.chatproject.model.responses.UserResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by David Bezalel Laoli on 10/21/2016.
 */
public class LoginPresenter {
    LoginResponse loginresponse;

    public LoginPresenter (LoginResponse loginresponse) {
        this.loginresponse= loginresponse;
    }

    public void doLogin(String username, String password){
        HashMap <String, String>_userdatas = new HashMap<>();
        _userdatas.put("username", username);
        _userdatas.put("password", password);

        ConnectionAPI.getInstance().getAPIModel().doLogin(_userdatas).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(response.body().getCode().equals("201")){
                    loginresponse.doLoginSuccess(response.body().getMessage());
                }else if(response.body().getCode().equals("401")){
                    loginresponse.doLoginFail(response.body().getMessage());
                }


            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                loginresponse.doConnectionError("Sorry, please check your connection.");

            }
        });
    }



}
