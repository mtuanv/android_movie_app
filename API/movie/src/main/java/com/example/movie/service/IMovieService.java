package com.example.movie.service;

import com.example.movie.entity.MovieEntity;
import com.example.movie.model.ListMovie;

public interface IMovieService {
    ListMovie getAllListMovie();
    MovieEntity getDetailMovie(int id);
}
