package com.vivelabhuila.calculadora;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sumar(View v){

        EditText txtA = (EditText) findViewById(R.id.txtA);
        EditText txtB = (EditText) findViewById(R.id.txtB);
        EditText txtC = (EditText) findViewById(R.id.txtC);

        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());

        int c = a + b;

        txtC.setText("" + c);

    }

    public void restar(View v){

        EditText txtA = (EditText) findViewById(R.id.txtA);
        EditText txtB = (EditText) findViewById(R.id.txtB);
        EditText txtC = (EditText) findViewById(R.id.txtC);

        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());

        int c = a - b;

        txtC.setText("" + c);

    }

    public void multiplicar(View v){

        EditText txtA = (EditText) findViewById(R.id.txtA);
        EditText txtB = (EditText) findViewById(R.id.txtB);
        EditText txtC = (EditText) findViewById(R.id.txtC);

        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());

        int c = a * b;

        txtC.setText("" + c);

    }

    public void dividir(View v){

        EditText txtA = (EditText) findViewById(R.id.txtA);
        EditText txtB = (EditText) findViewById(R.id.txtB);
        EditText txtC = (EditText) findViewById(R.id.txtC);

        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());

        int c = a / b;

        txtC.setText("" + c);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
