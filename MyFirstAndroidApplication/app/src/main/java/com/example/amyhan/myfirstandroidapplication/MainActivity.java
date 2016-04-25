package com.example.amyhan.myfirstandroidapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private float height;
    private float weight;
    private float BMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        Button compute_button = (Button) findViewById(R.id.compute_button);
        final EditText height_value = (EditText) findViewById(R.id.height);
        final EditText weight_value = (EditText) findViewById(R.id.width);
        final TextView result = (TextView) findViewById(R.id.result);

        compute_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(height_value.getText().length() > 0 && weight_value.getText().length()> 0){
                    height = Float.parseFloat(height_value.getText().toString());
                    weight = Float.parseFloat(weight_value.getText().toString());
                    BMI = calculateBMI(weight,height);
                    if(BMI < 16){
                        result.setText("Your BMI: " + BMI + "( Severely underweight )");
                    }else if(BMI < 18.5){
                        result.setText("Your BMI: " + BMI + "( Underweight )");
                    }else if(BMI < 25){
                        result.setText("Your BMI: " + BMI + "( Normal )");
                    }else if(BMI < 30){
                        result.setText("Your BMI: " + BMI + "( Overweight )");
                    }else{
                        result.setText("Your BMI: " + BMI + "( Obese )");
                    }
                }


            }
        });


    }

    private float calculateBMI(float weight, float height){
        height = (height /100);
        return (float) (weight/(height*height));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
