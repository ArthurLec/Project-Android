package com.vogella.projectandroid.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.vogella.projectandroid.R;

public class SecondActivity extends AppCompatActivity {

    //private static final String ListGhibli = "list_ghibli";
    private static final String POS = "pos_ghibli";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        showDescription();
    }

    public void showDescription() {

        // Get the text view where the heading is displayed
        TextView headingView = findViewById(R.id.textview_label);

        // Get the count from the intent extras

        String ghibli = getIntent().getStringExtra(POS);
        // Display the random number.
        Log.d("description",ghibli);

        // Substitute the max value into the string resource
        // for the heading, and update the heading
        //
        headingView.setText("description: "+ghibli);
    }
}
