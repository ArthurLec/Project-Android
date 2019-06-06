package com.vogella.projectandroid.controller;

import com.vogella.projectandroid.RestApiGhibli;
import com.vogella.projectandroid.model.Ghibli;
import com.vogella.projectandroid.view.MainActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyController {
    public MainActivity view;
    private RestApiGhibli restApiGhibli;

    public MyController(MainActivity view, RestApiGhibli restApiGhibli) {
        this.view = view;
        this.restApiGhibli = restApiGhibli;
    }

    public void onCreate() {
        Call<List<Ghibli>> call = restApiGhibli.getGhibliData();
        call.enqueue(new Callback<List<Ghibli>>() {
            @Override
            public void onResponse(Call<List<Ghibli>> call, Response<List<Ghibli>> response) {
                List<Ghibli> restGhibliResponse = response.body();
                List<Ghibli> ghibliList = restGhibliResponse;
                view.showList(ghibliList);
            }

            @Override
            public void onFailure(Call<List<Ghibli>> call, Throwable t) {

            }
        });
    }
}
