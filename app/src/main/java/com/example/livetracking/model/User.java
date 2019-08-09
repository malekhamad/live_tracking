package com.example.livetracking.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.jar.Attributes;

public class User {
    @SerializedName("id")
    private int id;
    @SerializedName("username")
    private String Name;
    @SerializedName("userpass")
    private String password;


    public User(int id, String Name, String password) {
        this.id = id;
        this.Name = Name;
        this.password = password;

    }

    public int getId() {
        return id;
    }
    public String getName(){
     return Name ;
    }

    public String getPassword(){
        return password ;
    }

}