package com.ozwhver.seven.gameseven;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Integer firstNum;
    private Integer secondNum;
    private int count;
    private Integer[] mThumbIds = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_4, R.drawable.image_5, R.drawable.image_6, R.drawable.image_7, R.drawable.image_8
            ,R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_4, R.drawable.image_5, R.drawable.image_6, R.drawable.image_7, R.drawable.image_8};
    private Integer firstPos;
    private Integer secondPos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final GridView gridView = (GridView) findViewById(R.id.GridView1);

        //sets the data behind this gridView
        gridView.setAdapter(new ImageAdapter(this));

        //registerForContextMenu(gridView);
        count = 0;

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GridView g = (GridView) findViewById(R.id.GridView1);
                Integer resourceId = (Integer) g.getItemAtPosition(position);

                ImageView imageView = (ImageView) findViewById(mThumbIds[2]);
                imageView.setImageResource(R.drawable.image_9);

                if(count == 1){
                    secondNum = resourceId;
                    secondPos = position;
                    if(firstNum.equals(secondNum) && (count != 0)){

                        Toast.makeText(MainActivity.this, "first Position: " + mThumbIds[firstPos], Toast.LENGTH_SHORT).show();




                    }else{

                    }
                    count = 0;
                }
                if(count == 0){
                    firstNum = resourceId;
                    firstPos = position;
                    count = 1;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about:
                Intent i = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(i);
                break;
            case R.id.exit:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        GridView g = (GridView) findViewById(R.id.GridView1);
        Integer resourceId = (Integer) g.getItemAtPosition(item.getItemId());
        switch (item.getGroupId()){
            case 1:
                final WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
                try{
                    wallpaperManager.setResource(resourceId);
                    Toast.makeText(getApplicationContext(), "Your wallpaper has been changed!!", Toast.LENGTH_LONG).show();
                }catch(IOException e){
                    e.printStackTrace();
                }
                break;
            case 2:
                Intent i = new Intent(MainActivity.this, ImagePreview.class);
                i.putExtra("id", resourceId);
                startActivity(i);
                break;
        }

        return true;

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Context Menu");
        AdapterView.AdapterContextMenuInfo cmi = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.add(1, cmi.position, 0, "Set as wallpaper");
        menu.add(2, cmi.position, 0, "View Image");
    }
}
