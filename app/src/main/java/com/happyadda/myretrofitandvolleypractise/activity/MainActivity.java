package com.happyadda.myretrofitandvolleypractise.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.happyadda.myretrofitandvolleypractise.R;
import com.happyadda.myretrofitandvolleypractise.adapter.MovieAdapter;
import com.happyadda.myretrofitandvolleypractise.model.Movie;
import com.happyadda.myretrofitandvolleypractise.model.MovieResponse;
import com.happyadda.myretrofitandvolleypractise.rest.ApiCleint;
import com.happyadda.myretrofitandvolleypractise.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final static String API_KEY = "7e8f60e325cd06e164799af1e317d7a7";
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        //Retrofit code
        ApiInterface apiService = ApiCleint.getCleint().create(ApiInterface.class);
        Call<MovieResponse> call = apiService.getTopRtaedMovies(API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                List<Movie> movies = response.body().getResults();
                Log.d("TAG", "Number of movies received: " + movies.size());
                recyclerView.setAdapter(new MovieAdapter(movies, R.layout.list_item_movie, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });
    }
}
