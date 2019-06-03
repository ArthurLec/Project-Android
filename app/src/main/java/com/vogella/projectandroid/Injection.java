package com.vogella.projectandroid;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Injection {
    private static RestApiGhibli restApiGhibli;

    //Singleton
    public static RestApiGhibli getRestApi(){
        if(restApiGhibli == null){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://ghibliapi.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            restApiGhibli = retrofit.create(RestApiGhibli.class);
        }
        return restApiGhibli;
    }
}
