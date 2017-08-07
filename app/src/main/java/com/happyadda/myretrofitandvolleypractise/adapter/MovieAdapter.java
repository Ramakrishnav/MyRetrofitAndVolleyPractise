package com.happyadda.myretrofitandvolleypractise.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.happyadda.myretrofitandvolleypractise.R;
import com.happyadda.myretrofitandvolleypractise.model.Movie;

import java.util.List;

/**
 * Created by dumadu on 31/07/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieVeiwHolder> {

     private List<Movie> movies;
     private int rowLayout;
     private Context context;

     public MovieAdapter(List<Movie> movies,int rowLayout,Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
     }


    public class MovieVeiwHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView movieSubTitle;
        TextView movieDescription;
        TextView rating;

        public MovieVeiwHolder(View itemView) {
            super(itemView);
            moviesLayout = (LinearLayout) itemView.findViewById(R.id.movies_layout);
            movieTitle = (TextView) itemView.findViewById(R.id.title);
            movieSubTitle = (TextView) itemView.findViewById(R.id.subtitle);
            movieDescription = (TextView) itemView.findViewById(R.id.description);
            rating = (TextView) itemView.findViewById(R.id.rating);
        }
    }


    @Override
    public MovieAdapter.MovieVeiwHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieVeiwHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieAdapter.MovieVeiwHolder holder, int position) {
        holder.movieTitle.setText(movies.get(position).getTitle());
        holder.movieSubTitle.setText(movies.get(position).getReleaseDate());
        holder.movieDescription.setText(movies.get(position).getOverview());
        holder.rating.setText(movies.get(position).getVoteAverage().toString());

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


}
