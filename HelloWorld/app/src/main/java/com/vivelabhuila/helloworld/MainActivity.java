package com.vivelabhuila.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saludar(View v){

        EditText txtName = (EditText) findViewById(R.id.txtName);
        TextView txtSaludo = (TextView) findViewById(R.id.txtSaludo);

        txtSaludo.setText("Hola " + txtName.getText());

    }

}
