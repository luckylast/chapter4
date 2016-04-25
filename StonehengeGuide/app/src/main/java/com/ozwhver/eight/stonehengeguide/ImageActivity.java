package com.ozwhver.eight.stonehengeguide;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class ImageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
    }

    public void returnToMainActivity(View v) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));

    }
}
