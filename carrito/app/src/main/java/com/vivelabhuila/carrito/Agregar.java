package com.vivelabhuila.carrito;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class Agregar extends ActionBarActivity {

    public double presupuesto;
    public String lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        presupuesto = getIntent().getExtras().getDouble("presupuesto");
        lista = getIntent().getExtras().getString("lista");

    }

    public void volver(View v) {
        Intent i = new Intent(this, Carrito.class);
        i.putExtra("presupuesto", presupuesto);
        i.putExtra("lista", lista);
        startActivity(i);
    }

    public void agregar(View v) {

        EditText txtElemento = (EditText) findViewById(R.id.txtElemento);
        EditText txtValor = (EditText) findViewById(R.id.txtValor);

        String elemento = txtElemento.getText().toString();
        String valor = txtValor.getText().toString();

        lista += "\n" + elemento + "\t" + valor;
        presupuesto -= Double.parseDouble(valor);

        volver(v);
    }

}
