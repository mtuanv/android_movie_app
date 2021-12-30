package com.example.movie.service;

import com.example.movie.entity.MovieEntity;
import com.example.movie.model.ListMovie;
import com.example.movie.repository.IMovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MovieService implements IMovieService {

    @Autowired
    IMovieRepo movieRepo;

    @Override
    public ListMovie getAllListMovie() {
        ListMovie model = new ListMovie();

        List<MovieEntity> listTrending = movieRepo.findAll();
        List<MovieEntity> listHot = movieRepo.findAll();
        List<MovieEntity> listSuggest = movieRepo.findAll();
        List<MovieEntity> listWatch = movieRepo.findAll();

        Collections.shuffle(listTrending);
        Collections.shuffle(listHot);
        Collections.shuffle(listSuggest);
        Collections.shuffle(listWatch);

        model.setListTrending(listTrending);
        model.setListHot(listHot);
        model.setListSuggest(listSuggest);
        model.setListWatch(listWatch);

        return model;
    }

    @Override
    public MovieEntity getDetailMovie(int id) {
        return movieRepo.findById(id).get();
    }
}
