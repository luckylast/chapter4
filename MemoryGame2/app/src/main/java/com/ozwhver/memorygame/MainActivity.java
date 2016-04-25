package com.ozwhver.memorygame;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends Activity {

    final Random ran = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    private int getResourceID(String str, String drawable, Context applicationContext) {
        final int ResourceId = applicationContext.getResources().getIdentifier(str, drawable,applicationContext.getApplicationInfo().packageName);
        if(ResourceId == 0){
            throw new IllegalArgumentException
                    (
                            "No resource string found with name " + str
                    );
        }
        else
        {
            return ResourceId;
        }
    }


}



