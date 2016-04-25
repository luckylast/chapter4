package com.example.amyhan.myforthapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {
    private final int PHONE =  0 ;
    private final int WEBSITE = 1;
    private ListView intentListView;
    private ArrayAdapter<String> adapter;
    private List<ContactObject> contactsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //inflate your view
        setContentView(R.layout.content_main);
        intentListView = (ListView) findViewById(R.id.listView1);

        //initialize the list and add item
        contactsList = new ArrayList<ContactObject>();
        contactsList.add(new ContactObject("Android One", "111-1111-1111", "www.androidATC.com"));
        contactsList.add(new ContactObject("Android Two", "222-2222-2222", "www.androidATC.com"));
        contactsList.add(new ContactObject("Android Three", "333-3333-3333", "www.androidATC.com"));
        contactsList.add(new ContactObject("Android Four", "444-4444-4444", "www.androidATC.com"));

        List<String> listName = new ArrayList<String>();
        for(int i = 0; i < contactsList.size(); i++){
            listName.add(contactsList.get(i).getName());
        }

        //initialize the arrayadapter object
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, listName);
        //set the adapter of the listview
        intentListView.setAdapter(adapter);

        intentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, ContactPageActivity.class);
                i.putExtra("Object", contactsList.get(position));
                startActivityForResult(i, 0);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(data == null){
            return;
        }
        Bundle resultData = data.getExtras();
        String value = resultData.getString("value");
        switch (resultCode){
            case PHONE:
                //implicit intent to make a call
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + value)));
                break;
            case WEBSITE:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + value)));
                break;

        }

    }
}

