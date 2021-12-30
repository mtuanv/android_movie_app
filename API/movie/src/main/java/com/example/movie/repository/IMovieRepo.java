package com.example.movie.repository;

import com.example.movie.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieRepo extends JpaRepository<MovieEntity, Integer> {
}
