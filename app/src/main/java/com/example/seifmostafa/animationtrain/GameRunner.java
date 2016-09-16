package com.example.seifmostafa.animationtrain;

import android.util.Log;

/**
 * Created by seifmostafa on 16/09/16.
 */
public class GameRunner extends Thread {
    private volatile boolean running = true;
    @Override
    public void run() {
        while (running)
        {
            Log.i("GameRunner","Running");
            try {
                Thread.sleep(300);
            }catch (Exception e){
                Log.e("GameRunner",e.toString());
            }
        }
    }
    public void shutdown(){
        running=false;
    }
}
