package com.vivelabhuila.externalapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

import com.vivelabhuila.externalapp.web.service.DeleteBookService;
import com.vivelabhuila.externalapp.web.service.EditBookService;


public class EditActivity extends ActionBarActivity {

    private EditText txtTitle;

    String idObtained;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        idObtained = getIntent().getExtras().get("idObtained").toString();
        String title = getIntent().getExtras().get("title").toString();

        txtTitle = (EditText) findViewById(R.id.txtTitle);
        txtTitle.setText(title);

    }

    public void edit(View v){

        String titleModified = txtTitle.getText().toString();
        EditBookService editBookService = new EditBookService();
        editBookService.execute(idObtained, titleModified);
        setResult(RESULT_OK);
        finish();
    }

    public void delete(View v){
        DeleteBookService deleteBookService = new DeleteBookService();
        deleteBookService.execute(idObtained);
        setResult(RESULT_OK);
        finish();
    }

}
