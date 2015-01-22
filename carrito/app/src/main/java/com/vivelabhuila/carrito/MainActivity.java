package com.vivelabhuila.carrito;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void continuar(View v){

        // Obtener presupuesto
        EditText txtPresupuesto = (EditText) findViewById(R.id.txtPresupuesto);
        double presupuesto = Double.parseDouble(txtPresupuesto.getText().toString());

        // Crear llamado a actividad carrito
        Intent i = new Intent(this, Carrito.class);

        // ingresar parametros a el llamado
        i.putExtra("presupuesto", presupuesto);

        // hacer llamado a segunda actividad
        startActivity(i);

    }

}
