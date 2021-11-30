package com.micheledefloriodev.recyclerview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIinterface {
    @GET("movielist.json")
    Call<List<Movie>> getAllMovies();
}
