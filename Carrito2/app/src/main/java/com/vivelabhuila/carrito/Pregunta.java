package com.vivelabhuila.carrito;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;


public class Pregunta extends ActionBarActivity {

    ArrayList<String> list;
    int position;
    double total;
    String item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta);

        item = getIntent().getExtras().getString("item");
        list = (ArrayList<String>) getIntent().getExtras().get("list");
        position = getIntent().getExtras().getInt("position");
        total = getIntent().getExtras().getDouble("total");

        String element = item.split(" - ")[0];
        String value = item.split(" - ")[1];

        EditText txtElement = (EditText) findViewById(R.id.txtElemento);
        EditText txtValue = (EditText) findViewById(R.id.txtValor);

        txtElement.setText(element);
        txtValue.setText(value);

    }

    public void edit(View v) {

        EditText txtElement = (EditText) findViewById(R.id.txtElemento);
        EditText txtValue = (EditText) findViewById(R.id.txtValor);

        String element = txtElement.getText().toString();
        String value = txtValue.getText().toString();

        if (!item.split(" - ")[1].equals(value)) {
            double diferencia = Double.parseDouble(item.split(" - ")[1]) - Double.parseDouble(value);
            total -= diferencia;
        }

        String newItem = element + " - " + value;

        list.remove(position);
        list.add(position, newItem);

        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        i.putExtra("list", list);
        i.putExtra("total", total);
        startActivity(i);
    }

    public void delete(View v) {

        EditText txtValue = (EditText) findViewById(R.id.txtValor);
        String value = txtValue.getText().toString();

        list.remove(position);

        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        i.putExtra("list", list);
        i.putExtra("total", total - Double.parseDouble(value));
        startActivity(i);

    }

}
