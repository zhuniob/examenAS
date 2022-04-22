package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditarEmpleado extends AppCompatActivity {

    EditText txtBuscarCedula;
    EditText txtCedula, txtNombres, txtApellidos, txtFechaContrato, txtSalario, txtDiscapacidad, txtHorario;
    Button btnBuscarCedula, btnActualizarEmpleado, btnEliminarEmpleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_empleado);

        buscarCedulaEmpleado();
        actualizarEmpleado();
        eliminarEmpleado();

    }

    public void buscarCedulaEmpleado(){
        btnBuscarCedula = findViewById(R.id.btnBuscarCedula);
        txtBuscarCedula  = findViewById(R.id.txtBuscarCedula);

        txtCedula = findViewById(R.id.txtCedulaEditar);
        txtNombres = findViewById(R.id.txtNombresEditar);
        txtApellidos = findViewById(R.id.txtApellidosEditar);
        txtFechaContrato = findViewById(R.id.txtFechaContratoEditar);
        txtSalario = findViewById(R.id.txtSalarioEditar);
        txtDiscapacidad = findViewById(R.id.txtDiscapacidadEditar);
        txtHorario = findViewById(R.id.txtHorarioEditar);

        btnBuscarCedula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Empleados empleadoBuscar = new Empleados();
                empleadoBuscar.buscarEmpleado(EditarEmpleado.this, empleadoBuscar, txtBuscarCedula.getText().toString());
                txtCedula.setText(empleadoBuscar.getCedula());
                txtNombres.setText(empleadoBuscar.getNombres());
                txtApellidos.setText(empleadoBuscar.getApellidos());
                txtFechaContrato.setText(empleadoBuscar.getFechaContrato());
                txtSalario.setText(empleadoBuscar.getSalario());
                txtDiscapacidad.setText(empleadoBuscar.getDiscapacidad());
                txtHorario.setText(empleadoBuscar.getHorario());
            }
        });
    }


    public void actualizarEmpleado(){
        btnActualizarEmpleado = findViewById(R.id.btnActualizar);
        txtCedula = findViewById(R.id.txtCedulaEditar);
        txtNombres = findViewById(R.id.txtNombresEditar);
        txtApellidos = findViewById(R.id.txtApellidosEditar);
        txtFechaContrato = findViewById(R.id.txtFechaContratoEditar);
        txtSalario = findViewById(R.id.txtSalarioEditar);
        txtDiscapacidad = findViewById(R.id.txtSalarioEditar);
        txtHorario = findViewById(R.id.txtHorarioEditar);

        btnActualizarEmpleado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Empleados empleadoActual = new Empleados();
                empleadoActual.setNombres(txtNombres.getText().toString());
                empleadoActual.setApellidos(txtApellidos.getText().toString());
                empleadoActual.setFechaContrato(txtFechaContrato.getText().toString());
                empleadoActual.setDiscapacidad(txtDiscapacidad.getText().toString());
                empleadoActual.setSalario(txtSalario.getText().toString());
                empleadoActual.setHorario(txtHorario.getText().toString());

                empleadoActual.editarEmpleado(EditarEmpleado.this, txtCedula.getText().toString());
                Intent intent = new Intent(EditarEmpleado.this, ListadoEmpleados.class);
                startActivity(intent);
            }
        });
    }


    public void eliminarEmpleado() {
        btnEliminarEmpleado = findViewById(R.id.btnEliminar);
        txtCedula = findViewById(R.id.txtCedulaEditar);
        btnEliminarEmpleado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Empleados empleadoEliminar = new Empleados();
                empleadoEliminar.eliminarEmpleado(EditarEmpleado.this, txtCedula.getText().toString());
                Toast.makeText(EditarEmpleado.this, "Elimino Correctamente", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(EditarEmpleado.this, ListadoEmpleados.class);
                startActivity(intent);
            }
        });
    }


}