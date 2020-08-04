package com.twu.biblioteca;

public class Movies {
    private String title;
    private String director;
    private int year;
    private double movieRating;
    private String imdb;

    public Movies(String title, String director, int year, double movieRating, String imdb) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.movieRating = movieRating;
        this.imdb = imdb;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDirector(){
        return this.director;
    }

    public int getYear(){
        return this.year;
    }

    public double getMovieRating() { return this.movieRating; }

    public String getImdb() { return this.imdb; }

}
