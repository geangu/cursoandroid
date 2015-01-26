package com.vivelabhuila.notes;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class CreateFile extends Activity {


    EditText txtTitle;
    EditText txtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_file);

        txtTitle = (EditText) findViewById(R.id.txtTitle);
        txtContent = (EditText) findViewById(R.id.txtContent);

    }

    public void goBack(View v) {
        setResult(RESULT_CANCELED);
        finish();
    }

    public void save(View v) {

        String title = txtTitle.getText().toString();
        String content = txtContent.getText().toString();

        try {
            File file = new File(Utils.FOLDER_PATH, title + ".txt");
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            osw.write(content);
            osw.flush();
            osw.close();
            setResult(RESULT_OK);

        } catch (FileNotFoundException e) {
            setResult(999);
            e.printStackTrace();
        } catch (IOException e) {
            setResult(999);
            e.printStackTrace();
        }

        finish();
    }

}
