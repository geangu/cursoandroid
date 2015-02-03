package com.vivelabhuila.database;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

import com.vivelabhuila.database.controller.BookController;
import com.vivelabhuila.database.domain.Book;


public class EditActivity extends ActionBarActivity {

    EditActivity activity;
    BookController controller;

    long id;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        id = getIntent().getExtras().getLong("idObtained");
        title = getIntent().getExtras().getString("title");

        ((EditText) findViewById(R.id.txtTitle)).setText(title);

        activity = this;
        controller = new BookController(this);

    }

    public void delete(View v) {

        Book book = new Book(id, "");
        if (controller.delete(book)) {
            setResult(RESULT_OK);
        } else {
            setResult(RESULT_CANCELED);
        }

        finish();
    }

    public void save(View v) {

        title = ((EditText) findViewById(R.id.txtTitle)).getText().toString();

        Book book = controller.update(new Book(id, title));

        if (book.getTitle().equals(title)) {
            setResult(RESULT_OK);
        } else {
            setResult(RESULT_CANCELED);
        }

        finish();
    }

}
