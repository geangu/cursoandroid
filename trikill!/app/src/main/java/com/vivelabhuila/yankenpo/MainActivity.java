package com.vivelabhuila.yankenpo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    boolean turnoX = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView) findViewById(R.id.txtTurno)).setText("Turno de " + (turnoX ? "X" : "O"));
    }

    public boolean validarTriqui() {


        String txt00 = ((Button) findViewById(R.id.btn00)).getText().toString();
        String txt01 = ((Button) findViewById(R.id.btn01)).getText().toString();
        String txt02 = ((Button) findViewById(R.id.btn02)).getText().toString();

        String txt10 = ((Button) findViewById(R.id.btn10)).getText().toString();
        String txt11 = ((Button) findViewById(R.id.btn11)).getText().toString();
        String txt12 = ((Button) findViewById(R.id.btn12)).getText().toString();

        String txt20 = ((Button) findViewById(R.id.btn20)).getText().toString();
        String txt21 = ((Button) findViewById(R.id.btn21)).getText().toString();
        String txt22 = ((Button) findViewById(R.id.btn22)).getText().toString();


        // lineas horizontales
        if (txt00.equals(txt01) && txt00.equals(txt02) && !txt00.equals("")) {
            return true;
        }
        if (txt10.equals(txt11) && txt10.equals(txt12) && !txt10.equals("")) {
            return true;
        }
        if (txt20.equals(txt21) && txt20.equals(txt22) && !txt20.equals("")) {
            return true;
        }

        // lineas verticales
        if (txt00.equals(txt10) && txt00.equals(txt20) && !txt00.equals("")) {
            return true;
        }
        if (txt01.equals(txt11) && txt01.equals(txt21) && !txt01.equals("")) {
            return true;
        }
        if (txt02.equals(txt12) && txt02.equals(txt22) && !txt02.equals("")) {
            return true;
        }

        // lineas diagonales
        if (txt00.equals(txt11) && txt00.equals(txt22) && !txt00.equals("")) {
            return true;
        }

        if (txt02.equals(txt11) && txt02.equals(txt20) && !txt02.equals("")) {
            return true;
        }

        return false;
    }

    public void nuevoJuego(View v){
        ((Button) findViewById(R.id.btn00)).setText("");
        ((Button) findViewById(R.id.btn01)).setText("");
        ((Button) findViewById(R.id.btn02)).setText("");
        ((Button) findViewById(R.id.btn10)).setText("");
        ((Button) findViewById(R.id.btn11)).setText("");
        ((Button) findViewById(R.id.btn12)).setText("");
        ((Button) findViewById(R.id.btn20)).setText("");
        ((Button) findViewById(R.id.btn21)).setText("");
        ((Button) findViewById(R.id.btn22)).setText("");

        ((TextView) findViewById(R.id.txtGanador)).setText("");

    }


    public void logica(Button btn) {
        if (btn.getText().toString().equals("")) {
            if (turnoX) {
                btn.setText("X");
            } else {
                btn.setText("O");
            }

            if (validarTriqui()) {
                // Mensaje para ganador
                ((TextView) findViewById(R.id.txtGanador)).setText("El Ganador es " + (turnoX ? "X" : "O"));
                return;
            } else {
                // Cambio de turno
                turnoX = !turnoX;
                ((TextView) findViewById(R.id.txtTurno)).setText("Turno de " + (turnoX ? "X" : "O"));
            }

        } else {
            Toast.makeText(this, "Ya tiene valor :(", Toast.LENGTH_LONG).show();
            return;
        }
    }

    public void click(View v) {
        Button btn = (Button) findViewById(v.getId());
        logica(btn);
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
