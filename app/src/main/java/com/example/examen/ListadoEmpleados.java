package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ListadoEmpleados extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Empleados> listEmpleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_empleados);

        listEmpleado = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.listadoRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(ListadoEmpleados.this));
    }

    public void consultarEmpleados(){
        Empleados empleado = new Empleados();
        listEmpleado = empleado.listaEmpleados(ListadoEmpleados.this);
    }

}

