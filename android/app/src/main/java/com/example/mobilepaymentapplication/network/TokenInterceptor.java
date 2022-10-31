package com.example.mobilepaymentapplication.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TokenInterceptor implements Interceptor {

    private static String new_access_token = "";


    public static void setAccessToken(String access_token){
        new_access_token = access_token;
//        System.out.println("access_token" + access_token);
//        System.out.println("new_access_token" + new_access_token);
    }

    public static String getAccessToken(){
        return  new_access_token;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        //rewrite the request to add bearer token
//        System.out.println("New Access Token: " + new_access_token);

        Request request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer " + new_access_token)
                .build();
        return chain.proceed(request);
    }
}
