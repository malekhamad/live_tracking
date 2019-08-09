package com.example.livetracking.model;

import android.util.Log;

import androidx.lifecycle.Observer;

import com.example.livetracking.view_model.UserViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
   private ApiInterface apiInterface ;
   private List<User>userList;


    public Repository(String baseUrl){
        userList= new ArrayList<>();
        apiInterface = ApiClient.getInstance(baseUrl).create(ApiInterface.class);
        final Call<List<User>>userCall = apiInterface.getUsers();
        userCall.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
              //  userList.addAll(response.body());
               // Log.i("information",response.body().toString());
              //  Log.i("name is ",String.valueOf(userList.size())) ;
                    UserViewModel.userLiveList.postValue(response.body());

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                 //userList.addAll(null);
                Log.e("error response",t.getMessage());
            }
        });

    }

   public List<User> getListData(){
        return this.userList;
    }
}
