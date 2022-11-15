package com.example.proyecto_mani;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import java.util.ArrayList;

import Clases.Ecuacion;

public class Comprar_Mani_act extends AppCompatActivity {

    private Spinner spnManiTipo, spnCantidadMani;
    private TextView montoPago, vuelto;
    private EditText montoUsuario;
    private Button alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar__mani_act);

        spnManiTipo = (Spinner)findViewById(R.id.spn1);
        spnCantidadMani = (Spinner)findViewById(R.id.spn2);
        montoPago = (TextView) findViewById(R.id.txt);
        vuelto = (TextView) findViewById(R.id.txt2);
        montoUsuario = (EditText)findViewById(R.id.etMonto);
        alerta = (Button) findViewById(R.id.button);

        alerta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertas = new AlertDialog.Builder(Comprar_Mani_act.this);
                alertas.setMessage("¿Seguro que desea comprar este producto?")
                        .setCancelable(false)
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {


                                    int Precio = Integer.parseInt(montoPago.getText().toString());
                                    int Pago = Integer.parseInt(montoUsuario.getText().toString());
                                    int vuelto2 = Pago - Precio;
                                    if (Pago >= Precio) {
                                        vuelto.setTextColor(Color.GREEN);
                                        vuelto.setText("Su compra fue realizada correctamente, su vuelto es: " + vuelto2);
                                    } else {
                                        int deuda = vuelto2 * -1;
                                        vuelto.setTextColor(Color.RED);
                                        vuelto.setText("Su compra ha sido rechazada, debe pagar la siguiente diferencia: " + deuda);
                                    }
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.cancel();
                            }
                        });
                AlertDialog titulo = alertas.create();
                titulo.setTitle("Compra");
                titulo.show();
            }
        });

        ArrayList<String> listaManies = (ArrayList<String>) getIntent().getSerializableExtra("listaManies");
        ArrayList<String> listaCantidad = (ArrayList<String>) getIntent().getSerializableExtra("listaCantidad");

        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaManies);
        ArrayAdapter<String> adapt2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaCantidad);


        spnManiTipo.setAdapter(adapt);
        spnCantidadMani.setAdapter(adapt2);
    }
    public void Confirmar(View v)
    {
        int val = Integer.parseInt(spnCantidadMani.getSelectedItem().toString());
        int vacio;
        String hola = spnManiTipo.getSelectedItem().toString();


        if(hola.equalsIgnoreCase("Maní Normal"))
        {
            vacio  = 2950; //kilo de mani
            Ecuacion ecu = new Ecuacion(vacio,val);
            ecu.Resultado();
            montoPago.setTextColor(Color.CYAN);
            montoPago.setText(ecu.Resultado());
        }
        else if (hola.equalsIgnoreCase("Maní Salado"))
        {
            vacio = 3200; //kilo de mani salado
            Ecuacion ecu = new Ecuacion(vacio,val);
            ecu.Resultado();
            montoPago.setTextColor(Color.CYAN);
            montoPago.setText(ecu.Resultado());
        }
        else if (hola.equalsIgnoreCase("Maní Confitado"))
        {
            vacio = 3990; // kilo de mani confitado
            Ecuacion ecu = new Ecuacion(vacio,val);
            ecu.Resultado();
            montoPago.setTextColor(Color.CYAN);
            montoPago.setText(ecu.Resultado());
        }
        else if (hola.equalsIgnoreCase("Maní con Miel"))
        {
            vacio = 4120 ; // kilo de mani con miel
            Ecuacion ecu = new Ecuacion(vacio,val);
            ecu.Resultado();
            montoPago.setTextColor(Color.CYAN);
            montoPago.setText(ecu.Resultado());
        }

        else if (hola.equalsIgnoreCase("Maní Chino"))
        {
            vacio = 4990; // kilo de mani Chino
            Ecuacion ecu = new Ecuacion(vacio,val);
            ecu.Resultado();
            montoPago.setTextColor(Color.CYAN);
            montoPago.setText(ecu.Resultado());
        }

    }

}