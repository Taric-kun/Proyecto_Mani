package com.example.proyecto_mani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class Menu_act extends AppCompatActivity {

        private ViewFlipper vf;
        private int[] imagen = {R.drawable.a, R.drawable.b,R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);

        vf = (ViewFlipper)findViewById(R.id.slider);

        for(int i = 0; i < imagen.length; i++)
        {
            Slider(imagen[i]);
        }

    }

    public void Slider(int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        vf.addView(view);
        vf.setFlipInterval(2800);
        vf.setAutoStart(true);


        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);
    }
    public void map(View v)
    {
        Intent i = new Intent(this, Ubicacion_Local_act.class);
        startActivity(i);
    }
    public void Comprar(View v)
    {
        ArrayList<String>manies = new ArrayList<String>();
        ArrayList<String>cantidad = new ArrayList<String>();

        manies.add("Maní Normal");
        manies.add("Maní Salado");
        manies.add("Maní Confitado");
        manies.add("Maní con Miel");
        manies.add("Maní Chino");


        cantidad.add("1");
        cantidad.add("2");
        cantidad.add("3");
        cantidad.add("4");
        cantidad.add("5");
        cantidad.add("6");
        cantidad.add("7");
        cantidad.add("8");
        cantidad.add("9");
        cantidad.add("10");

        Intent i = new Intent(this, Comprar_Mani_act.class);
        i.putExtra("listaManies", manies);
        i.putExtra("listaCantidad", cantidad);
        startActivity(i);
    }
    public void BaseDeDatos(View v)
    {
        Intent i = new Intent(this, BDatos_act.class);
        startActivity(i);
    }
    public void Info(View v)
    {
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }
}