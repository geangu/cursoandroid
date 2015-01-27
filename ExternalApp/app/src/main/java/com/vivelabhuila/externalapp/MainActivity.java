package com.vivelabhuila.externalapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.vivelabhuila.externalapp.web.service.CreateBookService;
import com.vivelabhuila.externalapp.web.service.DeleteBookService;
import com.vivelabhuila.externalapp.web.service.FindAllBookService;

import java.util.ArrayList;


public class MainActivity extends Activity {

    ListView listView;
    public ArrayList<String> list;
    public ArrayAdapter<String> adapter;

    MainActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        activity = this;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String idObtained = list.get(position).toString().split(" - ")[0];
                String title = list.get(position).toString().split(" - ")[1];

                Intent i = new Intent(activity, EditActivity.class);
                i.putExtra("idObtained", idObtained);
                i.putExtra("title", title);

                startActivityForResult(i, 1);

            }
        });

        updateList(null);

    }

    public void create(View v){
        EditText text = (EditText) findViewById(R.id.txtTitle);
        String title = text.getText().toString();
        CreateBookService create = new CreateBookService(this);
        create.execute(title);
        updateList(v);
    }


    public void updateList(View v){
        FindAllBookService service = new FindAllBookService(this);
        service.execute();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            updateList(null);
        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }

    }
}
