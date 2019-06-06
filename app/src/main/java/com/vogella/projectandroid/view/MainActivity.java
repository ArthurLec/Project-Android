package com.vogella.projectandroid.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.vogella.projectandroid.Injection;
import com.vogella.projectandroid.R;
import com.vogella.projectandroid.controller.MyController;
import com.vogella.projectandroid.model.Ghibli;

import java.util.List;

public class MainActivity extends Activity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private MyController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.my_recycler_view);

        controller = new MyController(this, Injection.getRestApi());
        controller.onCreate();
    }
    public void showList(List<Ghibli> ghibliList) {
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        //Instanciation de layoutManager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // define an adapter
        //Instanciation de mAdapter
        mAdapter = new Adapter(ghibliList,this);
        recyclerView.setAdapter(mAdapter);
    }
}
