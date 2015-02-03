package com.vivelabhuila.database;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.vivelabhuila.database.controller.BookController;
import com.vivelabhuila.database.domain.Book;

import java.util.ArrayList;


public class MainActivity extends Activity {

    public ArrayList<String> list;
    public ArrayAdapter<String> adapter;

    MainActivity activity;
    BookController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = this;
        controller = new BookController(this);

        list = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                long idObtained = Long.parseLong(list.get(position).split(" - ")[0]);
                String title = list.get(position).split(" - ")[1];
                Intent i = new Intent(activity, EditActivity.class);
                i.putExtra("idObtained", idObtained);
                i.putExtra("title", title);
                startActivityForResult(i, 1);

            }
        });

        refresh();

    }

    private void refresh() {
        ArrayList<Book> books = controller.findAll();
        list.clear();
        for (Book book : books) {
            list.add(book.getId() + " - " + book.getTitle());
        }
        adapter.notifyDataSetChanged();
    }

    public void create(View v) {

        String title = ((EditText) findViewById(R.id.txtTitle)).getText().toString();

        Book book = controller.create(new Book(0, title));

        if (book.getId() > 0) {
            list.add(book.getId() + " - " + book.getTitle());
            adapter.notifyDataSetChanged();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            Toast.makeText(this, getString(R.string.msg_change_ok), Toast.LENGTH_SHORT).show();
            refresh();
        } else {
            Toast.makeText(this, getString(R.string.msg_change_fail), Toast.LENGTH_SHORT).show();
        }

    }
}
