package com.mann.retrofitexample;

import com.mann.retrofitexample.Class.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyWebService {
    String base_url = "https://jsonplaceholder.typicode.com/";
    String feed = "posts";
    String photo = "photos";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(base_url).addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET(feed)
    Call<List<Model>> getPosts();

    @GET(photo)
    Call<List<Photo>> getPhoto();
//    @GET("comments")
//    Call<List<Comment>> getComments(@Query("postId") int postid);
}
