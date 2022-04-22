package com.example.examen;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class Empleados {

    private String cedula;
    private String nombres;
    private String apellidos;
    private String fechaContrato;
    private String horario;
    private String salario;
    private String discapacidad;

    ArrayList<Empleados> listado;

    public Empleados(){}

    public Empleados(String cedula, String nombres, String apellidos, String fechaContrato, String horario, String salario, String discapacidad) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaContrato = fechaContrato;
        this.horario = horario;
        this.salario = salario;
        this.discapacidad = discapacidad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(String fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }


    //  métodos CRUD

    //  crear insertar empleados en la db
    public void crearEmpleado(Context context){
        DbHelper db = new DbHelper(context);
        String nosql = "insert into " + DbEmpleados.TABLA_EMPLEADOS + "(" +
                " " + DbEmpleados.CEDULA_EMPLEADO + "," +
                " " + DbEmpleados.NOMBRES_EMPLEADO + "," +
                " " + DbEmpleados.APELLIDOS_EMPLEADO + "," +
                " " + DbEmpleados.FECHA_CONTRATO + "," +
                " " + DbEmpleados.DISCAPACIDAD + "," +
                " " + DbEmpleados.SALARIO + "," +
                " " + DbEmpleados.HORARIO + ") " +
                "values ('" + getCedula() + "','" + getNombres() + "','" + getApellidos() + "', '" + getFechaContrato() + "','" + getDiscapacidad() + "','" + getSalario() + "','" + getHorario() + "')";
        db.noQuery(nosql);
        db.close();
    }


    //  listar empleados dentro de la db
    public ArrayList<Empleados> listaEmpleados(Context context) {

        DbHelper dbHelper = new DbHelper(context);
        String sql = "select * from " + DbEmpleados.TABLA_EMPLEADOS + ";";
        listado = new ArrayList<Empleados>();
        Cursor cursor = dbHelper.query(sql);

        while (cursor.moveToNext()) {
            Empleados empleadoActual = new Empleados();
            empleadoActual.setCedula("DNI: " + cursor.getString(0));
            empleadoActual.setNombres("Nombres: " + cursor.getString(1));
            empleadoActual.setApellidos("Apellidos: " + cursor.getString(2));
            empleadoActual.setFechaContrato("FechaContrato: " + cursor.getString(3));
            empleadoActual.setDiscapacidad("Discapacidad: " + cursor.getString(4));
            empleadoActual.setSalario("Salario: " + cursor.getString(4));
            empleadoActual.setHorario("Horario: " + cursor.getString(4));
            listado.add(empleadoActual);
            dbHelper.close();
        }
        return listado;
    }


    //  buscar empleados desde la db
    public void buscarEmpleado(Context context, Empleados empleado, String cedula){
        DbHelper dbHelper= new DbHelper(context);
        String sql = "select * from " + DbEmpleados.TABLA_EMPLEADOS + " where cedula_empleado='" + cedula + "';";
        Cursor cursor = dbHelper.query(sql);
        while (cursor.moveToNext()){
            empleado.setCedula(cursor.getString(0));
            empleado.setNombres(cursor.getString(1));
            empleado.setApellidos(cursor.getString(2));
            empleado.setFechaContrato(cursor.getString(3));
            empleado.setDiscapacidad(cursor.getString(4));
            empleado.setSalario(cursor.getString(5));
            empleado.setHorario(cursor.getString(6));
            dbHelper.close();
        }
    }


    //  editar empleados
    public void editarEmpleado(Context context, String cedula){
        DbHelper  dbHelper = new DbHelper(context);
        String nosql = "update " + DbEmpleados.TABLA_EMPLEADOS + " set " +
                " nombres_empleado='" + getNombres() + "', " +
                " apellidos_empleado='" + getApellidos() + "', " +
                " fecha_contrato='" + getFechaContrato() + "', " +
                " discapacidad='" + getDiscapacidad() + "', " +
                " salario='" + getSalario() + "', " +
                " horario='" + getHorario() + "', " +
                " where cedula_empleado='" + cedula + "';";
        dbHelper.noQuery(nosql);
        dbHelper.close();
    }


    //  eliminar empleados
    public void eliminarEmpleado(Context context, String cedula) {
        DbHelper dbHelper = new DbHelper(context);
        String nosql = "delete from " + DbEmpleados.TABLA_EMPLEADOS + " where cedula_empleado='" + cedula + "';";
        dbHelper.noQuery(nosql);
        dbHelper.close();
    }

}
