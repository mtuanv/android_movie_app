package com.example.movie.controller;

import com.example.movie.model.BaseResponse;
import com.example.movie.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/movie")
public class HomeController {
    @Autowired
    IMovieService movieService;

    @GetMapping
    public BaseResponse getAllListMovie(@RequestParam(required = false) Integer id){
        BaseResponse res = new BaseResponse();
        if(id != null){
            res.data = movieService.getDetailMovie(id);
        }else{
            res.data = movieService.getAllListMovie();
        }
        return res;
    }
}
