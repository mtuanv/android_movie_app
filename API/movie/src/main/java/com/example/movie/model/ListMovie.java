package com.example.movie.model;

import com.example.movie.entity.MovieEntity;

import java.util.List;

public class ListMovie {
    private List<MovieEntity> listTrending;
    private List<MovieEntity> listHot;
    private List<MovieEntity> listSuggest;
    private List<MovieEntity> listWatch;

    public ListMovie() {
    }

    public ListMovie(List<MovieEntity> listTrending, List<MovieEntity> listHot, List<MovieEntity> listSuggest, List<MovieEntity> listWatch) {
        this.listTrending = listTrending;
        this.listHot = listHot;
        this.listSuggest = listSuggest;
        this.listWatch = listWatch;
    }

    public List<MovieEntity> getListTrending() {
        return listTrending;
    }

    public void setListTrending(List<MovieEntity> listTrending) {
        this.listTrending = listTrending;
    }

    public List<MovieEntity> getListHot() {
        return listHot;
    }

    public void setListHot(List<MovieEntity> listHot) {
        this.listHot = listHot;
    }

    public List<MovieEntity> getListSuggest() {
        return listSuggest;
    }

    public void setListSuggest(List<MovieEntity> listSuggest) {
        this.listSuggest = listSuggest;
    }

    public List<MovieEntity> getListWatch() {
        return listWatch;
    }

    public void setListWatch(List<MovieEntity> listWatch) {
        this.listWatch = listWatch;
    }
}
