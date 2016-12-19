package com.example.alvan.chatproject.presenter.auth;

import com.example.alvan.chatproject.model.connections.ConnectionAPI;
import com.example.alvan.chatproject.model.responses.UserResponse;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by David Bezalel Laoli on 10/21/2016.
 */
public class RegisterPresenter {
    RegisterResponse registerresponse;

    public RegisterPresenter(RegisterResponse registerresponse) {
        this.registerresponse = registerresponse;
    }

    public void doRegister(String username, String email, String password) {
        HashMap<String, String> _userdatas = new HashMap<>();
        _userdatas.put("username", username);
        _userdatas.put("email", email);
        _userdatas.put("password", password);

        ConnectionAPI.getInstance().getAPIModel().doRegister(_userdatas).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.body().getCode().equals("201")) {
                    registerresponse.doRegisterSuccess(response.body().getMessage());
                } else if (response.body().getCode().equals("401")) {
                    registerresponse.doRegisterFail(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                registerresponse.doConnectionError("Sorry, please check your connection.");
            }
        });

    }
}
