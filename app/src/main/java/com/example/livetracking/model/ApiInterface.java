package com.example.livetracking.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    // create abstract method for retrofit . . . ;
    @GET("user_info.php")
    Call<List<User>> getUsers();

}