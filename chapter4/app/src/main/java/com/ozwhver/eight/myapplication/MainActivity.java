package com.ozwhver.eight.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private final int SHOW_SUBACTIVITY = 11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void buttonClicked(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra(Intent.EXTRA_TEXT, "News for you");
        startActivity(intent);
    }


    public void callActivity(View view) {
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("Value1", "This value one for ActivityTwo");
        i.putExtra("Value2", "This value two ActivityTwo");
        startActivityForResult(i,SHOW_SUBACTIVITY);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case SHOW_SUBACTIVITY:
                if(resultCode == Activity.RESULT_OK){
                    Bundle resultData = data.getExtras();
                    Log.i("Text", resultData.getString("TextReturned"));
                }
                break;
        }
    }
}
