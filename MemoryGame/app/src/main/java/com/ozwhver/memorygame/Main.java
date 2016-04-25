package com.ozwhver.memorygame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Main extends AppCompatActivity {

    MediaPlayer outSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main_activiey);
        outSong = MediaPlayer.create(Main.this, R.raw.untitled);
        outSong.start();
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
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void startGame(View view) {
        Intent intent = new Intent(this, ActivityOne.class);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        outSong.release();
        finish();
    }
}
