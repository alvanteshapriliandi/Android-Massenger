package com.example.alvan.chatproject.model.connections;

import com.example.alvan.chatproject.model.controller.APIModel;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
/**
 * Created by David Bezalel Laoli on 10/14/2016.
 */
public class ConnectionAPI {
    private static final String BASEURL = "http://192.168.1.227:1337/";
    private static ConnectionAPI instance;
    private static APIModel api;
    private static Retrofit retrofit;

    public static ConnectionAPI getInstance() {
        if (instance == null)
            instance =  new ConnectionAPI();
        return instance;
    }

    public APIModel getAPIModel() {
        return api;
    }

    private ConnectionAPI() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        api = retrofit.create(APIModel.class);
    }
}
