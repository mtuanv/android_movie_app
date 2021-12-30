package com.demo.filmt1911e.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.demo.filmt1911e.DetailActivity;
import com.demo.filmt1911e.MainActivity;
import com.demo.filmt1911e.R;
import com.demo.filmt1911e.response.MovieDto;

import java.util.List;

public class MovieAdapter1 extends RecyclerView.Adapter {

    private Activity activity;
    private List<MovieDto> listMovie;
    private OnMovieListener1 mOnMovieListener;

    public MovieAdapter1(Activity activity, OnMovieListener1 mOnMovieListener, List<MovieDto> listMovie) {
        this.activity = activity;
        this.mOnMovieListener = mOnMovieListener;
        this.listMovie = listMovie;
    }

    public void reloadData(List<MovieDto> list) {
        this.listMovie = list;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = ((Activity)parent.getContext()).getLayoutInflater().inflate(R.layout.item_movie1, parent, false);
        MovieHolder holder = new MovieHolder(itemView, mOnMovieListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MovieDto model = listMovie.get(position);
        MovieHolder vh = (MovieHolder) holder;
        vh.tvTitle.setText(model.getName());
        Glide.with(activity).load(model.getThumbnail()).into(vh.ivCover);
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView ivCover;
        TextView tvTitle;
        OnMovieListener1 onMovieListener;

        public MovieHolder(@NonNull View itemView, OnMovieListener1 onMovieListener) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            ivCover = itemView.findViewById(R.id.ivCover);
            this.onMovieListener = onMovieListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onMovieListener.onMovie1Click(listMovie.get(getAdapterPosition()).getId());
        }
    }

    public interface OnMovieListener1{
        void onMovie1Click(int id);
    }
}
