package com.ozwhver.firstgame;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by amyhan on 13/12/15.
 */
public class GamePanel extends SurfaceView implements SurfaceHolder.Callback{

    public static final int WIDTH = 856;
    public static final int HEIGHT = 480;
    private MainThread thread;
    private Background bg;

    public GamePanel(Context context) {
        super(context);

        //add callback to the surfaceholder to intercept events
        getHolder().addCallback(this);

        thread = new MainThread(getHolder(), this);

        //make

    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

        bg = new Background(BitmapFactory.decodeResource(getResources(), R.drawable.grassbg1));
        bg.setVector(-5);
        //we can safely started the game loop
        thread.setRunning = true;
        thread.run();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        boolean retry = true;
        while(retry){
            try{
                thread.setRunning(false); //try stop the thread
                thread.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        return super.onTouchEvent(event);
    }

    public void update(){
        bg.update();
    }

    @Override
    public void draw(Canvas canvas){
        final float scaleFactorX = getWidth()/WIDTH;
        final float scaleFacotrY = getHeight()/HEIGHT;
        if(canvas != null){
            final int savedState = canvas.save();
            canvas.scale(scaleFactorX, scaleFacotrY);
            bg.draw(canvas);
            canvas.restoreToCount(savedState);
        }
    }
}
