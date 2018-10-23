package com.example.bo.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.bo.recyclerview.model.Place;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Context context;
    FirebaseDatabase mDatabase;
    private DatabaseReference myref;

    FirebaseRecyclerOptions options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabase = FirebaseDatabase.getInstance();
        context = getApplicationContext();
        myref = mDatabase.getReference().child("Places");

        options = new FirebaseRecyclerOptions.Builder<Place>().setQuery(myref, Place.class).build();
        FirebaseRecyclerAdapter adapter = new FirebaseRecyclerAdapter<Place, ViewHolder>(options) {


            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
                return  new ViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(ViewHolder holder, int position, Place model) {
                holder.name.setText(model.getName());
                Glide.with(context).load(model.getImage()).into(holder.imageView);
            }
        };


        RecyclerView recyclerView = findViewById(R.id.recycler);
        adapter.startListening();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
