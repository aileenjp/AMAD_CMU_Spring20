package com.example.movies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.movies.model.Movie;
import com.example.movies.loader.JSONData;

import java.util.List;

public class MainActivity extends AppCompatActivity{
    List<Movie> topMovieList =JSONData.movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get data
        if (topMovieList.isEmpty()) {
            //topMovieList = JSONData.getJSON();
            JSONData.getJSON(this);
        }

        //get the recycler view
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        //define an adapter
        MyListAdapter adapter = new MyListAdapter(topMovieList, this);

        //assign the adapter to the recycler view
        recyclerView.setAdapter(adapter);

        //set a layout manager on the recycler view
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
