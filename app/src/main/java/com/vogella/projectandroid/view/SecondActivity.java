package com.vogella.projectandroid.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.vogella.projectandroid.R;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private static final String SelectedGhibli = "selected_ghibli";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        showDescription();
    }

    public void showDescription() {


        // Get the text view where the description is displayed
        TextView descriptionView = findViewById(R.id.descritionLabel);
        // Get the text view where the title is displayed
        TextView titleView = findViewById(R.id.titleLabel);
        TextView dateView = findViewById(R.id.dateLabel);
        TextView directorView = findViewById(R.id.directorLabel);
        TextView producerView = findViewById(R.id.producerLabel);
        TextView scoreView = findViewById(R.id.scoreLabel);


        //String ghibli = getIntent().getStringExtra(SelectedGhibli);
        ArrayList<String> ghibli = getIntent().getStringArrayListExtra(SelectedGhibli);

        titleView.setText("\n"+ghibli.get(0));
        descriptionView.setText("\nDescription : " + ghibli.get(1));
        dateView.setText("\n"+ghibli.get(2));
        directorView.setText("Director: "+ghibli.get(3));
        producerView.setText("Producer: "+ghibli.get(4));
        scoreView.setText(ghibli.get(5)+"/100");
    }
}
