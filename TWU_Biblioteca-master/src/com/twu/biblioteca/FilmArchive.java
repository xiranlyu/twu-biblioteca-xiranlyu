package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilmArchive {
    private List<Movie> movies = new ArrayList<Movie>(Arrays.asList(new Movie("Interstellar", "Christopher Nolan", 2014,
            9.4, "0816692", 3), new Movie("Billy Lynn's Long Halftime Walk", "Ang Lee", 2016,
            8.4, "2513074", 1), new Movie("1917", "Sam Mendes", 2019,
            8.5, "8579674", 2)));

    public List<Movie> getMovies () {
        return movies;
    }

    public String showMovieList() {
        StringBuilder result = new StringBuilder();
        for (Movie movie: movies) {
            result.append("title: ").append(movie.getTitle()).
                    append(" director: ").append(movie.getDirector()).
                    append(" year: ").append(movie.getYear()).
                    append(" rating: ").append(movie.getMovieRating()).
                    append(" IMDB: ").append(movie.getImdb()).append("\n");
        }
        System.out.println(result.toString());
        return result.toString();
    }

    public boolean checkoutMovies(String imdb) {
        for (Movie movie: movies) {
            if (imdb.equals(movie.getImdb()) && movie.getQuantity() > 0) {
                movie.setQuantity(movie.getQuantity() - 1);
                return true;
            }
        }
        return false;
    }

    public int getQuantityOfMovie(String imdb) {
        for (Movie movie: movies) {
            if (movie.getImdb().equals(imdb)) {
                return movie.getQuantity();
            }
        }
        return -1;
    }
}
