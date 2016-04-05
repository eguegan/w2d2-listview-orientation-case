package com.example.admin.listvieworientation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> al = new ArrayList<String>();
    private ArrayAdapter<String> itemsAdapter;

    private CustomObject mCustomObject;

    private String[] values = new String[] { "Mexico", "USA", "France" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCustomObject = (CustomObject) new CustomObject();

        ListView listview = (ListView) findViewById(R.id.am_listview_1);

        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, al);

        for(String country: values){
            al.add(country);
        }

        ListView listView = (ListView) findViewById(R.id.am_listview_1);
        listView.setAdapter(itemsAdapter);

        Button mButtonAdd = (Button) findViewById(R.id.am_btn_add);
        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                al.add("Item Added");
                itemsAdapter.notifyDataSetChanged();
            }
        });

        Button mButtonRemove = (Button) findViewById(R.id.am_btn_remove);
        mButtonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                al.remove(al.size() - 1);
                itemsAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){

        savedInstanceState.putStringArrayList("ItemsArray", al);
        mCustomObject.setlistSize(al.size());
        savedInstanceState.putParcelable("ParcelableSize", mCustomObject);

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        al = savedInstanceState.getStringArrayList("ItemsArray");
        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, al);

        ListView listView = (ListView) findViewById(R.id.am_listview_1);
        listView.setAdapter(itemsAdapter);

        Log.d("TAG_", "onRestoreInstanceState: " + mCustomObject.getlistSize());
        itemsAdapter.notifyDataSetChanged();
    }
}
