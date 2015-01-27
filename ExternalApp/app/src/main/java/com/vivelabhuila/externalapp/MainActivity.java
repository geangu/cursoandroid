package com.vivelabhuila.externalapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.vivelabhuila.externalapp.web.service.BookService;
import com.vivelabhuila.externalapp.web.service.FindAllBookService;

import java.util.ArrayList;


public class MainActivity extends Activity {

    ListView listView;
    public ArrayList<String> list;
    public ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        FindAllBookService findAllBookService = new FindAllBookService(this);
        findAllBookService.execute();

    }



}
