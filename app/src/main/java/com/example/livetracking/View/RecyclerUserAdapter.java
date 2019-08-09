package com.example.livetracking.View;

import android.content.Context;
import android.service.autofill.UserData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.livetracking.databinding.RecyclerListItemBinding;
import com.example.livetracking.model.User;
import com.example.livetracking.view_model.UserViewModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerUserAdapter extends RecyclerView.Adapter<RecyclerUserAdapter.RecyclerUserHolder> {
   private Context context ;
   private int resource ;;
   private List<User>userList= new ArrayList<>();

    // create constructor to pass data inside this adapter . . . ;
    public RecyclerUserAdapter(Context context , int resource){
        this.context = context ;
        this.resource = resource ;
    }

    @NonNull
    @Override
    public RecyclerUserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerListItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(context),resource,parent,false);
        return new RecyclerUserHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerUserHolder holder, int position) {
       User user =  userList.get(position);
        holder.listItemBinding.setUser(user);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }


    public class RecyclerUserHolder extends RecyclerView.ViewHolder{
        RecyclerListItemBinding listItemBinding ;
       public RecyclerUserHolder(RecyclerListItemBinding itemBinding) {
           super(itemBinding.getRoot());
           listItemBinding = itemBinding;
       }
    }
    public void getAllUser(List<User>userList){
        this.userList = userList ;
        this.notifyDataSetChanged();
    }
}
