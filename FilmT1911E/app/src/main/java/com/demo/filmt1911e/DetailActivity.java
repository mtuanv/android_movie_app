package com.demo.filmt1911e;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.demo.filmt1911e.network.ApiManager;
import com.demo.filmt1911e.response.BaseResponseDto;
import com.demo.filmt1911e.response.HomeContentDto;
import com.demo.filmt1911e.response.MovieDto;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initData(getIntent().getExtras().getInt("id"));
    }

    private void initData(int id){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiManager.SERVER)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiManager service = retrofit.create(ApiManager.class);
        service.apiGetMovie(id).enqueue(new Callback<BaseResponseDto<MovieDto>>() {
            @Override
            public void onResponse(Call<BaseResponseDto<MovieDto>> call, Response<BaseResponseDto<MovieDto>> response) {
                MovieDto model = response.body().getData();
                ImageView ivThumbnail = findViewById(R.id.ivThumbnail);
                TextView tvYear = findViewById(R.id.tvYear);
                TextView tvHour = findViewById(R.id.tvHour);
                TextView tvMinute = findViewById(R.id.tvMinute);
                TextView tvDescription = findViewById(R.id.tvDescription);
                TextView tvName = findViewById(R.id.tvName);
                int minute = model.getDuration() % 60;
                Glide.with(DetailActivity.this).load(model.getThumbnail()).into(ivThumbnail);
                tvYear.setText(model.getCreateAt().substring(0, 4));
                tvHour.setText(String.valueOf(model.getDuration() / 60).concat("h"));
                tvMinute.setText(minute == 0 ? "" : String.valueOf(minute).concat("m"));
                tvDescription.setText(model.getDescription());
                tvName.setText(model.getName());
            }

            @Override
            public void onFailure(Call<BaseResponseDto<MovieDto>> call, Throwable t) {

            }
        });
    }
}