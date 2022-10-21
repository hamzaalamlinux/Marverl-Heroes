package com.example.recyclerviewinmvm.apis;




import com.example.recyclerviewinmvm.models.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIServices
{
    @GET("marvel")
    Call<List<MovieModel>> getMovieList();
}
