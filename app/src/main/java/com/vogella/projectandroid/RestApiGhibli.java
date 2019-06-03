package com.vogella.projectandroid;

import com.vogella.projectandroid.model.Ghibli;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApiGhibli {
    @GET("films")
    Call<List<Ghibli>> getGhibliData();
}
