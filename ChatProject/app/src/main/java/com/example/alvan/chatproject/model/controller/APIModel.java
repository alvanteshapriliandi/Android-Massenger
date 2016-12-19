package com.example.alvan.chatproject.model.controller;

import com.example.alvan.chatproject.model.responses.UserResponse;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * Created by David Bezalel Laoli on 10/14/2016.
 */
public interface APIModel {

    @FormUrlEncoded
    @POST("user/register")
    Call<UserResponse> doRegister(@FieldMap HashMap<String, String> userdata);

    @FormUrlEncoded
    @PUT("user/login")
    Call<UserResponse> doLogin(@FieldMap HashMap<String, String> userdata);

}
