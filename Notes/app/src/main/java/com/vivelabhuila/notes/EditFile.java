package com.vivelabhuila.notes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class EditFile extends Activity {

    EditText txtTitle;
    EditText txtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_file);

        if ( getIntent().getExtras().getString("fileName") != null ) {

            String fileName = getIntent().getExtras().getString("fileName");
            txtTitle = (EditText) findViewById(R.id.txtTitle);
            txtTitle.setText(fileName);

            txtContent = (EditText) findViewById(R.id.txtContent);
            txtContent.setText(getFileContent(fileName));

        }


    }

    private String getFileContent(String title){

        String content = "";

        try {
            File file = new File(Utils.FOLDER_PATH, title);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while ( line != null ) {
                content += "\n" + line;
                line = br.readLine();
            }
            br.close();
            isr.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
            Toast.makeText(getApplicationContext(), "El archivo no existe", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Error leyendo en el archivo", Toast.LENGTH_LONG).show();
        }

        return content;
    }

    public void edit (View v) {

        String title = txtTitle.getText().toString();
        String content = txtContent.getText().toString();

        try {
            File file = new File(Utils.FOLDER_PATH, title);
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

    public void goBack(View v){
        Intent i = getIntent();
        i.putExtra("msg","Listo");
        setResult(RESULT_CANCELED);
        finish();
    }

}