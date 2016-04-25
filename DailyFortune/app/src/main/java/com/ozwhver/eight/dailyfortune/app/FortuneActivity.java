package com.ozwhver.eight.dailyfortune.app;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.ozwhver.eight.dailyfortune.AppControler;
import com.ozwhver.eight.dailyfortune.ConnectionDetector;
import com.ozwhver.eight.dailyfortune.MyPreferences;
import com.ozwhver.eight.dailyfortune.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

public class FortuneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fortune);

        MyPreferences pref = new MyPreferences(FortuneActivity.this);
        if(pref.isFirstTime()){
            Toast.makeText(FortuneActivity.this, "Hi"+pref.getUserName(),Toast.LENGTH_LONG).show();
            pref.setOld(true);
        }else{
            Toast.makeText(FortuneActivity.this, "Welcome back" + pref.getUserName(), Toast.LENGTH_LONG).show();
        }

        ConnectionDetector cd = new ConnectionDetector(this);
        if(cd.isConnectingToInternet()){
            getFortuneOnline();
        }


    }

    private void getFortuneOnline(){
        //set the fortune text to loadding
        final TextView fortuneTxt = (TextView) findViewById(R.id.fortune);
        fortuneTxt.setText("Loading...");
        //create an instance of the request
        JsonObjectRequest Request = new JsonObjectRequest(com.android.volley.Request.Method.GET,
                "http://www.iheartquotes.com/api/v1/random.json",
                (String) null,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Response", response.toString());
                        String fortune;
                        //parse the quote
                        try{
                            fortune = response.getString("quote");
                        }catch(JSONException e){
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),
                                    "Error: "+ e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                            fortune = "Error";
                        }
                        //set the fortune text to the parsed quote
                        fortuneTxt.setText(fortune);
                        writeToFile(fortune);
                    }
                },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Response","Error:" + error.getMessage());
                Toast.makeText(getApplicationContext(),error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        //add request to request queue
        AppControler.getInstance().addToRequestQueue(Request);
    }

    private void writeToFile(String fortune) {
        try{
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("Fortune.json", Context.MODE_PRIVATE));
            outputStreamWriter.write(fortune);
            outputStreamWriter.close();
        }catch(IOException e){
            Log.e("Message:", "File write failed:"+e.toString());
        }
    }



}
