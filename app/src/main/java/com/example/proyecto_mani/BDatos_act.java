package com.example.proyecto_mani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;

public class BDatos_act extends AppCompatActivity {

    private EditText edCodigo, edNombreProducto, edStock, edPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_datos_act);

        edCodigo = (EditText)findViewById(R.id.txt1);
        edNombreProducto = (EditText)findViewById(R.id.txt2);
        edStock = (EditText)findViewById(R.id.txt3);
        edPrecio  = (EditText)findViewById(R.id.txt4);

    }
    public void AgregarInsumos(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        if(!edCodigo.getText().toString().isEmpty())
        {
            ContentValues registro = new ContentValues();
            registro.put("codigo", edCodigo.getText().toString());
            registro.put("nombre", edNombreProducto.getText().toString());
            registro.put("stock", edStock.getText().toString());
            registro.put("precio", edPrecio.getText().toString());

            db.insert("mani",null,registro);
            db.close();
            Toast.makeText(this,"Se ha guardado el insumo correctamente.", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this,"Debe rellenar los campos solicitados.", Toast.LENGTH_LONG).show();
        }
    }
    public void MostrarInsumos(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Fichero", null, 1);
        SQLiteDatabase BD = admin.getWritableDatabase();

        String codigoreal = edCodigo.getText().toString();

        if(!codigoreal.isEmpty())
        {
            Cursor fila = BD.rawQuery("SELECT nombre, stock, precio FROM mani WHERE codigo="+codigoreal, null);

            if(fila.moveToFirst())
            {
                edNombreProducto.setText(fila.getString(0));
                edStock.setText(fila.getString(1));
                edPrecio.setText(fila.getString(2));

            }
            else
            {
                Toast.makeText(this, "No hay datos en los campos de la tabla maní.", Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(this, "No hay producto con el codigo asociado", Toast.LENGTH_LONG).show();
        }
    }
    public void EliminarInsumos(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Fichero", null, 1);
        SQLiteDatabase BD = admin.getWritableDatabase();

        String codigoreal = edCodigo.getText().toString();

        BD.delete("mani", "codigo ="+codigoreal, null);
        BD.close();
        Toast.makeText(this, "Has eliminado un producto", Toast.LENGTH_LONG).show();
    }
    public void ActualizarInsumos(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Fichero", null, 1);
        SQLiteDatabase BD = admin.getWritableDatabase();

        String codigoreal = edCodigo.getText().toString();

        ContentValues cont = new ContentValues();

        cont.put("codigo", edCodigo.getText().toString());
        cont.put("nombre", edNombreProducto.getText().toString());
        cont.put("stock", edStock.getText().toString());
        cont.put("precio", edPrecio.getText().toString());

        if(!codigoreal.isEmpty())
        {
            BD.update("mani", cont, "codigo ="+codigoreal, null);
            BD.close();
            Toast.makeText(this, "Has actualizado un campo", Toast.LENGTH_LONG).show();
        }
    }
    public void Limpiar(View v)
    {
        edCodigo.setText("");
        edNombreProducto.setText("");
        edPrecio.setText("");
        edStock.setText("");
    }
}