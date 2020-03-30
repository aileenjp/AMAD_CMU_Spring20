package com.example.movies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.movies.loader.OnDataReadyCallback;
import com.example.movies.model.Movie;
import com.example.movies.loader.JSONData;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnDataReadyCallback {
    List<Movie> topMovieList =JSONData.movieList;
    private MyListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get data
        if (topMovieList.isEmpty()) {
            JSONData.getJSON(this, this);
        }

        //get the recycler view
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        //define an adapter
        adapter = new MyListAdapter(topMovieList, this);

        //assign the adapter to the recycler view
        recyclerView.setAdapter(adapter);

        //set a layout manager on the recycler view
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Log.d("data", String.valueOf(topMovieList.size()));
    }

    @Override
    public void onDataReady(List<Movie> movieList) {
        adapter.setMovieList(movieList);
    }
}
