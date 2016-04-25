package com.ozwhver.eight.dailyfortune.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.ozwhver.eight.dailyfortune.MyPreferences;
import com.ozwhver.eight.dailyfortune.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        MyPreferences pref = new MyPreferences(MainActivity.this);
        if(!pref.isFirstTime()){
            Intent i = new Intent(getApplicationContext(), FortuneActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(i);
            finish();
        }

    }

    public void SaveUserName(View v){
        EditText usrName = (EditText) findViewById(R.id.editText);
        MyPreferences pref = new MyPreferences(MainActivity.this);
        pref.setUserName(usrName.getText().toString().trim());
        Intent i = new Intent(getApplicationContext(), FortuneActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(i);
        finish();
    }

}
