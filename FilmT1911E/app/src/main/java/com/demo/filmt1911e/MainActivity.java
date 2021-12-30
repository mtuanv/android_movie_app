package com.demo.filmt1911e;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.demo.filmt1911e.adapter.MovieAdapter1;
import com.demo.filmt1911e.adapter.MovieAdapter2;
import com.demo.filmt1911e.network.ApiManager;
import com.demo.filmt1911e.response.BaseResponseDto;
import com.demo.filmt1911e.response.HomeContentDto;
import com.demo.filmt1911e.response.MovieDto;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements MovieAdapter1.OnMovieListener1, MovieAdapter2.OnMovieListener2 {

    private int[] sampleImages = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img8, R.drawable.img9, R.drawable.img10};
    private List<MovieDto> listTrending = new ArrayList<>();
    private List<MovieDto> listHot = new ArrayList<>();
    private List<MovieDto> listSuggest = new ArrayList<>();
    private List<MovieDto> listWatch = new ArrayList<>();
    private MovieAdapter1 adapter1;
    private MovieAdapter2 adapter2;
    private MovieAdapter1 adapter3;
    private MovieAdapter2 adapter4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
        initData();
    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiManager.SERVER)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiManager service = retrofit.create(ApiManager.class);
        service.apiHome().enqueue(new Callback<BaseResponseDto<HomeContentDto>>() {
            @Override
            public void onResponse(Call<BaseResponseDto<HomeContentDto>> call, Response<BaseResponseDto<HomeContentDto>> response) {
                Log.d("TAG", "onResponse: ");
                BaseResponseDto<HomeContentDto> model = response.body();
                listTrending = model.getData().getListTrending();
                listHot = model.getData().getListHot();
                listSuggest = model.getData().getListSuggest();
                listWatch = model.getData().getListWatch();
                adapter1.reloadData(listTrending);
                adapter2.reloadData(listHot);
                adapter3.reloadData(listSuggest);
                adapter4.reloadData(listWatch);
                initCarouselView();
            }

            @Override
            public void onFailure(Call<BaseResponseDto<HomeContentDto>> call, Throwable t) {
                Log.d("TAG", "onFailure: " + t);
            }
        });
    }

    private void initRecyclerView() {
        //B2: Adapter
        adapter1 = new MovieAdapter1(this, this, listTrending);
        adapter2 = new MovieAdapter2(this, this, listHot);
        adapter3 = new MovieAdapter1(this, this, listSuggest);
        adapter4 = new MovieAdapter2(this, this, listWatch);

        //B3: Layout Manager
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager layoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager layoutManager4 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        //B4: RecyclerView
        RecyclerView rvTrending = findViewById(R.id.rvTrending);
        rvTrending.setLayoutManager(layoutManager1);
        rvTrending.setHasFixedSize(true);
        rvTrending.setAdapter(adapter1);

        RecyclerView rvHot = findViewById(R.id.rvHot);
        rvHot.setLayoutManager(layoutManager2);
        rvHot.setHasFixedSize(true);
        rvHot.setAdapter(adapter2);

        RecyclerView rvSuggest = findViewById(R.id.rvSuggest);
        rvSuggest.setLayoutManager(layoutManager3);
        rvSuggest.setHasFixedSize(true);
        rvSuggest.setAdapter(adapter3);

        RecyclerView rvWatch = findViewById(R.id.rvWatch);
        rvWatch.setLayoutManager(layoutManager4);
        rvWatch.setHasFixedSize(true);
        rvWatch.setAdapter(adapter4);
    }

    private void initCarouselView() {
        CarouselView carouselView = (CarouselView) findViewById(R.id.carouselView);
        ImageListener imageListener = new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                Glide.with(getApplicationContext()).load(listTrending.get(position).getThumbnail()).into(imageView);
            }
        };
        carouselView.setImageListener(imageListener);
        carouselView.setPageCount(listTrending.size());
        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("id", listTrending.get(position).getId());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onMovie1Click(int id) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    @Override
    public void onMovie2Click(int id) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}