package com.example.livetracking.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.livetracking.R;
import com.example.livetracking.databinding.ActivityMainBinding;
import com.example.livetracking.model.User;
import com.example.livetracking.model.UserService;
import com.example.livetracking.view_model.UserViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
UserViewModel userViewModel ;
List<User>userList = new ArrayList<>();
ActivityMainBinding mainBinding ;
RecyclerUserAdapter userAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        userAdapter = new RecyclerUserAdapter(MainActivity.this, R.layout.recycler_list_item);
        // for recycler view . . . ;
        mainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mainBinding.recyclerView.setHasFixedSize(true);
        mainBinding.recyclerView.setAdapter(userAdapter);

        userViewModel.getUserLiveList().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                userAdapter.getAllUser(users);

            }
        });




    }

    @Override
    protected void onStart() {
        super.onStart();
       startService(new Intent(MainActivity.this, UserService.class));
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopService(new Intent(MainActivity.this,UserService.class));
    }
}
