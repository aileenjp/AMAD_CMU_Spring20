package com.example.movies.model;

public class Movie {

    private int id;
    private String title;
    private String posterURL;
    private String rating;

    public Movie(int id, String title, String posterURL, String rating) {
        this.id = id;
        this.title = title;
        this.posterURL = posterURL;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterURL() {
        return posterURL;
    }

    public void setPosterURL(String posterURL) {
        this.posterURL = posterURL;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
