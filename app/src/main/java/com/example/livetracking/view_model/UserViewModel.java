package com.example.livetracking.view_model;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.livetracking.model.Repository;
import com.example.livetracking.model.User;

import java.util.List;

public class UserViewModel extends ViewModel {
  Repository repository ;
 public static MutableLiveData<List<User>> userLiveList;
    public UserViewModel (){
        userLiveList = new MutableLiveData<>();
        repository = new Repository("http://10.0.2.2/userProject/");
        //userLiveList.setValue(repository.getListData());
    }
    public MutableLiveData<List<User>>getUserLiveList(){
        return userLiveList;
    }
}
