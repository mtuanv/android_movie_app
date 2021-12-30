package com.demo.filmt1911e.response;

import java.util.List;

public class HomeContentDto {
    private List<MovieDto> listTrending;
    private List<MovieDto> listHot;
    private List<MovieDto> listSuggest;
    private List<MovieDto> listWatch;

    public List<MovieDto> getListTrending() {
        return listTrending;
    }

    public void setListTrending(List<MovieDto> listTrending) {
        this.listTrending = listTrending;
    }

    public List<MovieDto> getListHot() {
        return listHot;
    }

    public void setListHot(List<MovieDto> listHot) {
        this.listHot = listHot;
    }

    public List<MovieDto> getListSuggest() {
        return listSuggest;
    }

    public void setListSuggest(List<MovieDto> listSuggest) {
        this.listSuggest = listSuggest;
    }

    public List<MovieDto> getListWatch() {
        return listWatch;
    }

    public void setListWatch(List<MovieDto> listWatch) {
        this.listWatch = listWatch;
    }
}
