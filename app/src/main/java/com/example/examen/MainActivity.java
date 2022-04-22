package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnCrearBase, btnCrearEmpleado, btnMostrarEmpleados, btnEditarEmpleado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        crearDataBase();
        crearEmpleado();
        mostrarListado();
        buscar();
    }

    public void crearDataBase(){
        btnCrearBase = findViewById(R.id.btnCrearBase);
        btnCrearBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if (db != null) {
                    Toast.makeText(MainActivity.this, "DataBase Creada", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "DateBaseNot", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    public void crearEmpleado(){
        btnCrearEmpleado = findViewById(R.id.btnCrearEmpleado);
        btnCrearEmpleado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CrearEmpleado.class);
                startActivity(intent);
            }
        });
    }

    public  void mostrarListado(){
        btnMostrarEmpleados = findViewById(R.id.btnMostrarEmpleados);
        btnMostrarEmpleados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListadoEmpleados.class);
                startActivity(intent);
            }
        });
    }


    public void buscar(){
        btnEditarEmpleado = findViewById(R.id.btnEditarEmpleado);
        btnEditarEmpleado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EditarEmpleado.class);
                startActivity(intent);
            }
        });
    }

}