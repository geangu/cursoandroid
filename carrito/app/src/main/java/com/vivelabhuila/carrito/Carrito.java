package com.vivelabhuila.carrito;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class Carrito extends ActionBarActivity {


    private double presupuesto;

    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);


        Bundle bundle = getIntent().getExtras();
        this.presupuesto = bundle.getDouble("presupuesto");

        if(bundle.getString("lista")!=null){
            TextView carrito = (TextView) findViewById(R.id.txtCarrito);
            carrito.setText(bundle.getString("lista"));
        }

        // Mostrar el presupuesto que se envia desde la actividad anterior
        TextView txtPresupuesto = (TextView) findViewById(R.id.txtPresupuesto);
        txtPresupuesto.setText("Saldo: " + presupuesto);

    }

    public void add(View v){

        Intent i = new Intent(this, Agregar.class);
        TextView carrito = (TextView) findViewById(R.id.txtCarrito);
        i.putExtra("presupuesto", presupuesto);
        i.putExtra("lista", carrito.getText());
        startActivity(i);

    }

}
