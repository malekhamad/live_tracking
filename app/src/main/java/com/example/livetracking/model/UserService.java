package com.example.livetracking.model;

import android.app.IntentService;
import android.app.Service;
import android.content.AbstractThreadedSyncAdapter;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.livetracking.view_model.UserViewModel;

public class UserService extends Service {
    Thread thread;
    public UserService() {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       Runnable r = new Runnable() {
           @Override
           public void run() {
               while (true){
                   synchronized (this){
                       try {
                           wait(10000);
                            Repository repository = new Repository("http://10.0.2.2/userProject/");
                              Log.i("ss","sl");
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
               }
           }
       };
        thread = new Thread(r);
       thread.start();
        return START_STICKY;
    }



    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }





    @Override
    public void onDestroy() {
        super.onDestroy();
        thread.stop();

    }
}
