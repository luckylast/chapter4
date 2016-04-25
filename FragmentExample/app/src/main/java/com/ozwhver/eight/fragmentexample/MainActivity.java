package com.ozwhver.eight.fragmentexample;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button analogButton, digitalButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setActionBar(toolbar);
        getActionBar().setTitle("Clock");
        toolbar.setSubtitle("tells the time");
        toolbar.setLogo(R.drawable.location);


        analogButton = (Button) findViewById(R.id.button_analog);
        analogButton.setOnClickListener(this);

        digitalButton = (Button) findViewById(R.id.button_digital);
        digitalButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Fragment fragment;
        if(v == analogButton){
            fragment = new FragmentAnalog();

        }else{
            fragment = new FragmentDigital();
        }
        replaceFragment(fragment);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        transaction.replace(R.id.fragment_container,fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        android.support.v4.app.Fragment fragment;
        int id = item.getItemId();
        switch (id){
            case R.id.menu_date:
                startActivity(new Intent(Settings.ACTION_DATE_SETTINGS));
                break;
            case R.id.menu_location:
                startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                break;
            case R.id.menu_sleep:
                startActivity(new Intent(Settings.ACTION_SOUND_SETTINGS));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
