package com.example.proyecto_mani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nombre, contraseña;
    private Button ingresar;
    private ProgressBar barra;
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.pltxt_nombre);
        contraseña = (EditText) findViewById(R.id.etContraseña);
        ingresar = (Button) findViewById(R.id.btn_login);
        barra = (ProgressBar) findViewById(R.id.pb_login);
        texto = (TextView)findViewById(R.id.txt);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nombre.getText().toString().equalsIgnoreCase("android") && contraseña.getText().toString().equals("1234"))
                {
                    texto.setTextColor(Color.GREEN);
                    texto.setText("Bienvenido/a, espere mientras abrimos el menú");
                    new Task().execute();
                }
                else
                {
                  texto.setTextColor(Color.RED);
                  texto.setText("Usuario o contraseña incorrectos.");
                }
            }
        });

        barra.setVisibility(View.INVISIBLE);
    }

    class Task extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {

            barra.setVisibility(View.VISIBLE);
        }


        @Override
        protected String doInBackground(String... strings) {

            for(int i = 1; i < 10; i++)
            {
                try {
                    Thread.sleep(1000);

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            return null;
        }


        @Override
        protected void onPostExecute(String s) {

                barra.setVisibility(View.INVISIBLE);

                Intent i = new Intent(getBaseContext(),Menu_act.class);
                startActivity(i);

        }

    }

}