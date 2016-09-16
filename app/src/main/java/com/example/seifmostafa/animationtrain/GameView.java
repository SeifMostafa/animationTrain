package com.example.seifmostafa.animationtrain;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by seifmostafa on 16/09/16.
 */
public class GameView extends SurfaceView {

    Bitmap arrowDown;
   private GameRunner gameRunner;
    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        arrowDown = BitmapFactory.decodeResource(getResources(),R.drawable.arrow_down_1);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        SurfaceHolder holder = getHolder();
        Canvas canvas = holder.lockCanvas();
        if(canvas !=null)
        {
            canvas.drawColor(Color.WHITE);
            canvas.drawBitmap(arrowDown,100,100,null);
            holder.unlockCanvasAndPost(canvas);
        }
        return true;
    }
    
    public void surfaceCreated(SurfaceHolder surfaceHolder){
        Log.i("GameView","surfaceCreated");
        gameRunner = new GameRunner();
        gameRunner.start();
    }
    public void surfaceChanged(SurfaceHolder surfaceHolder){
        Log.i("GameView","surfaceChanged");

    }
    public void surfaceDestroyed(SurfaceHolder surfaceHolder){
        Log.i("GameView","surfaceDestroyed");
        if(gameRunner!=null){
            gameRunner.shutdown();
            while (gameRunner!=null){
                try {
                    gameRunner.join();
                    gameRunner=null;
                } catch (InterruptedException e) {
                    Log.e("InterruptedException",e.toString());
                }
            }
        }

    }
}
