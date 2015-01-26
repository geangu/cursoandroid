package com.vivelabhuila.notes;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    ArrayList<String> files = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        this.files = new ArrayList<String>();
        loadFiles();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, this.files);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(this.adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), EditFile.class);
                String fileName = files.get(position);
                i.putExtra("fileName", fileName);
                startActivityForResult(i,2);
            }
        });

        adapter.notifyDataSetChanged();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        loadFiles();
        adapter.notifyDataSetChanged();

        if (requestCode == 1) {

            if( resultCode == RESULT_OK){
                Toast.makeText(this, "Archivo creado con exito.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "No se creo ningun archivo.", Toast.LENGTH_SHORT).show();
            }

        } else if (requestCode == 2 ) {
            if( resultCode == RESULT_OK){
                Toast.makeText(this, "Archivo modificado con exito.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "No se modifico ningun archivo.", Toast.LENGTH_SHORT).show();
            }
        }



    }


    private void loadFiles(){

        this.files.clear();
        File folder = new File(Utils.FOLDER_PATH);

        if (folder.exists()) {
            File[] files = folder.listFiles();
            for (File file : files){
                if(file.exists() && file.getName() != null){
                    this.files.add(file.getName());
                }
            }
        } else {
            folder.mkdir();
        }
    }

    public void newNote(View v){

        Intent i = new Intent(getApplicationContext(), CreateFile.class);
        startActivityForResult(i,1);

    }

}
