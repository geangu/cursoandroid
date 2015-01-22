package com.vivelabhuila.lista;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends Activity {

    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView1);
        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg = getResources().getString(R.string.your_selection_is);
                Toast.makeText(getApplicationContext(), msg + arrayList.get(position), Toast.LENGTH_LONG).show();
            }
        });

    }

    public void add(View v) {

        EditText text = (EditText) findViewById(R.id.editText1);
        String item = text.getText().toString();
        arrayList.add(item);
        adapter.notifyDataSetChanged();

    }

}
