package com.ozwhver.memorygame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class ActivityTwo extends AppCompatActivity {

    GridView grid_view;
    private Integer image_id[] = {
            R.drawable.image2_1,R.drawable.image2_2,
            R.drawable.image2_3,R.drawable.image2_4,
            R.drawable.image2_5,R.drawable.image2_6,
            R.drawable.image2_7,R.drawable.image2_0,
            R.drawable.image2_8,R.drawable.image2_9,

            R.drawable.image2_1,R.drawable.image2_2,
            R.drawable.image2_3,R.drawable.image2_4,
            R.drawable.image2_5,R.drawable.image2_6,
            R.drawable.image2_7,R.drawable.image2_0,
            R.drawable.image2_8,R.drawable.image2_9,
    };
    private int first;
    private int count;
    private int second;
    private Handler mHandler = new Handler();
    private ImageView firstImageView;
    private MediaPlayer outSong;
    private ImageView secondImageView;
    private final Handler handler = new Handler();
    private TextView textView;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main1);
        outSong = MediaPlayer.create(ActivityTwo.this, R.raw.card_flip);
        textView = (TextView) findViewById(R.id.textView);
        score = 0;


        image_id = shuffleArray(image_id);


        grid_view = (GridView) findViewById(R.id.gridView);
        grid_view.setAdapter(new ImageAdapter2(this));
        grid_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> parent, final View view, final int position, long id) {


                //Log.i("amy press count", String.valueOf(count));
                if (count == 0) {
                    first = position;
                    firstImageView = (ImageView) view;
                    if(firstImageView.getTag() != null){
                        count = -1;
                        //Log.i("amy", String.valueOf(firstImageView.getTag()));
                    }else{

                        outSong.start();
                        firstImageView.setImageResource(image_id[first]);
                    }
                }

                if (count == 1) {
                    second = position;
                    secondImageView = (ImageView) view;
                    if(secondImageView.getTag() != null){
                        count = 0;

                    }else{

                        outSong.start();
                        secondImageView.setImageResource(image_id[second]);

                        if(first != second){
                            new Thread(new LoadTask(first, second, firstImageView, secondImageView, textView, score)).start();
                        }else{
                            count = 0;
                        }
                    }

                }

                count ++;
                if(count >= 2){
                    count = 0;
                    if(count ==1){
                        first = 0;
                        second =99;
                    }

                }


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.sixteen:
                Intent intent = new Intent(this, ActivityOne.class);
                startActivity(intent);
                return true;
            case R.id.twentyFive:
                Intent intent2 = new Intent(this, ActivityTwo.class);
                startActivity(intent2);
                return true;
            case R.id.thirtySix:
                Intent intent3 = new Intent(this, ActivityThree.class);
                startActivity(intent3);
                return true;
            case R.id.exit:
                finish();
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    static Integer[] shuffleArray(Integer[] array) {
        Random rgen = new Random();  // Random number generator

        for (int i = 0; i < array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }

        return array;
    }


    private class LoadTask implements Runnable {
        ImageView one;
        ImageView two;
        int first;
        int second;
        TextView textView;
        int score;

        public LoadTask(int first, int second, ImageView firstImageView, ImageView secondImage, TextView textView, int score) {
            this.first = first;
            this.second = second;
            this.one = firstImageView;
            this.two = secondImage;
            this.textView = textView;
            this.score = score;
        }

        @Override
        public void run() {

            handler.post(new Runnable() {
                @Override
                public void run() {

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {

                        //compare
                        if (image_id[first].equals(image_id[second])) {
                            firstImageView.setTag(first);
                            secondImageView.setTag(second);
                            score = Integer.parseInt(textView.getText().toString());
                            score = score + 200;
                            //Log.i("amy", String.valueOf(score));
                            String displayScore = String.valueOf(score);
                            textView.setText(displayScore);

                        }else{



                            secondImageView.setImageResource(R.drawable.cardback2);


                            firstImageView.setImageResource(R.drawable.cardback2);
                        }

                        if(count >= 2){
                            count = 0;
                            first = 0;
                            second = 99;
                        }

                    }


                }
            });

        }
    }
}
