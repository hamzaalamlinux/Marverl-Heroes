package com.example.recyclerviewinmvm.apis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance
{
    public static String baseurl="https://simplifiedcoding.net/demos/"; // volley_array.json
    private static Retrofit retrofit;

    public static Retrofit getRetroClient()
    {
        if(retrofit==null)
        {
            retrofit= new Retrofit.Builder()
                    .baseUrl(baseurl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
