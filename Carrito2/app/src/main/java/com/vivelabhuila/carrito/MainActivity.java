package com.vivelabhuila.carrito;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends Activity {

    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    double total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = (ListView) findViewById(R.id.listView);

        if(getIntent().getExtras()!= null && getIntent().getExtras().get("list") != null){
            list = (ArrayList<String>) getIntent().getExtras().get("list");
        } else {
            list = new ArrayList<String>();
        }

        if(getIntent().getExtras()!= null && getIntent().getExtras().get("total") != null) {
            total = getIntent().getExtras().getDouble("total");
            TextView txtTotal = (TextView) findViewById(R.id.txtTotal);
            txtTotal.setText("" + total);
        }



        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String item = list.get(position);
                Intent i = new Intent(getApplicationContext(), Pregunta.class);
                i.putExtra("position", position);
                i.putExtra("item", item);
                i.putExtra("list", list);
                i.putExtra("total", total);
                startActivity(i);

            }
        });

    }

    public void add(View v){

        EditText txtElemento = (EditText) findViewById(R.id.txtElemento);
        EditText txtValor = (EditText) findViewById(R.id.txtValor);

        TextView txtTotal = (TextView) findViewById(R.id.txtTotal);

        total = Double.parseDouble(txtTotal.getText().toString());
        double valor = Double.parseDouble(txtValor.getText().toString());

        total += valor;

        txtTotal.setText("" + total);

        list.add(txtElemento.getText().toString() + " - " + valor);


        adapter.notifyDataSetChanged();

    }


}
