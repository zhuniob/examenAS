package com.example.examen;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CrearEmpleado extends AppCompatActivity {

    EditText txtCedula, txtNombres, txtApellidos, txtFechaContrato, txtSalario, txtDiscapacidad, txtHorario;
    Button btnGuardarEmpleadoNuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_empleado);
        guardarEmpleadoNuevo();
    }


    public void guardarEmpleadoNuevo(){
        btnGuardarEmpleadoNuevo = findViewById(R.id.btnGuardarEmpleadoNuevo);
        txtCedula = findViewById(R.id.txtCedula);
        txtNombres = findViewById(R.id.txtNombres);
        txtApellidos = findViewById(R.id.txtApellidos);
        txtFechaContrato = findViewById(R.id.txtFechaContrato);
        txtSalario = findViewById(R.id.txtSalario);
        txtDiscapacidad = findViewById(R.id.txtDiscapacidad);
        txtHorario = findViewById(R.id.txtHorario);

        btnGuardarEmpleadoNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Empleados empleadoActual = new Empleados();
                empleadoActual.setCedula(txtCedula.getText().toString());
                empleadoActual.setNombres(txtNombres.getText().toString());
                empleadoActual.setApellidos(txtApellidos.getText().toString());
                empleadoActual.setFechaContrato(txtFechaContrato.getText().toString());
                empleadoActual.setSalario(txtSalario.getText().toString());
                empleadoActual.setDiscapacidad(txtDiscapacidad.getText().toString());
                empleadoActual.setHorario(txtHorario.getText().toString());

                empleadoActual.crearEmpleado(CrearEmpleado.this);
                Toast.makeText(CrearEmpleado.this, "Se creo el usuario", Toast.LENGTH_SHORT).show();
            }
        });
    }




}