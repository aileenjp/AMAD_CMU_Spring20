package com.example.movies.loader;

import com.example.movies.model.Movie;

import java.util.List;

public interface OnDataReadyCallback {
    void onDataReady(List<Movie> movieList);
}
