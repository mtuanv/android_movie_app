package com.demo.filmt1911e.network;

import com.demo.filmt1911e.response.BaseResponseDto;
import com.demo.filmt1911e.response.HomeContentDto;
import com.demo.filmt1911e.response.MovieDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiManager {

    String SERVER = "http://10.0.2.2:8081";

    @GET("/api/movie")
    Call<BaseResponseDto<HomeContentDto>> apiHome();

    @GET("/api/movie")
    Call<BaseResponseDto<MovieDto>> apiGetMovie(@Query("id") int id);
}
