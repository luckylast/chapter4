package com.ozwhver.seven.simpletodolist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class DynamicListViewActivity extends AppCompatActivity {

    private EditText item;
    private Button add;
    private ListView dynamicListView;
    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_list_view);

        item = (EditText) findViewById(R.id.myEditText);
        add = (Button) findViewById(R.id.myaddButton);
        dynamicListView = (ListView) findViewById(R.id.myListView);

        list = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(DynamicListViewActivity.this, android.R.layout.simple_list_item_1, list);

        dynamicListView.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add(item.getText().toString());
                //apply change on the adapter to refresh listview
                adapter.notifyDataSetChanged();

                item.setText("");
            }
        });
    }


}
