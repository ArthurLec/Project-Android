package com.vogella.projectandroid.view;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vogella.projectandroid.R;
import com.vogella.projectandroid.model.Ghibli;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Ghibli> values;
    private MainActivity mainActivity;

    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = v.findViewById(R.id.firstLine);
            txtFooter = v.findViewById(R.id.secondLine);
        }
    }

    private static final String SelectedGhibli = "selected_ghibli";
    public void infoDisplay(int position){

        // Create an Intent to start the second activity
        Intent infoIntent = new Intent(mainActivity, SecondActivity.class);
        final Ghibli selectedGhibli = values.get(position);
        // Add API info in ArrayList to put in second screen

        ArrayList<String> ghibli= new ArrayList<>() ;

        ghibli.add(selectedGhibli.getTitle());
        ghibli.add(selectedGhibli.getDescription());
        ghibli.add(selectedGhibli.getReleaseDate());
        ghibli.add(selectedGhibli.getDirector());
        ghibli.add(selectedGhibli.getProducer());
        ghibli.add(selectedGhibli.getScore());

        infoIntent.putStringArrayListExtra(SelectedGhibli,ghibli);

        // Start the new activity.
        mainActivity.startActivity(infoIntent);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public Adapter(List<Ghibli> values, MainActivity mainActivity) {
        this.values = values;
        this.mainActivity = mainActivity;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Ghibli selectedGhibli = values.get(position);
        holder.txtHeader.setText(selectedGhibli.getTitle());

        holder.txtFooter.setText("Id : " + selectedGhibli.getId());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                infoDisplay(position);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    public int getItemCount() {
        return values.size();
    }


}
