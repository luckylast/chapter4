package com.ozwhver.eight.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String value1 = extras.getString(Intent.EXTRA_TEXT);
            if(value1 != null){
                Toast.makeText(this, value1, Toast.LENGTH_LONG).show();
            }
        }

    }

    @Override
    public void finish(){
        Intent data = new Intent();
        data.putExtra("TextReturned", "This string is sent from ActivityTwo");
        setResult(RESULT_OK, data);
        super.finish();
    }
}
