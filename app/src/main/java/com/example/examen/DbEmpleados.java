package com.example.examen;

import java.util.Date;

public class DbEmpleados {

    public static final String TABLA_EMPLEADOS="empleados";
    public static final String CEDULA_EMPLEADO="cedula_empleado ";
    public static final String NOMBRES_EMPLEADO="nombres_empleado";
    public static final String APELLIDOS_EMPLEADO="apellidos_empleado";
    public static final String FECHA_CONTRATO = "fecha_contrato";
    public static final String DISCAPACIDAD = "discapacidad";
    public static final String SALARIO = "salario";
    public static final String HORARIO = "horario";

    public static final String CREAR_TABLA_EMPLEADOS = "create table" + TABLA_EMPLEADOS + " (" +
            CEDULA_EMPLEADO + "text primary key, " +
            " " + NOMBRES_EMPLEADO + "text, " +
            " " + APELLIDOS_EMPLEADO + " text, " +
            " " + FECHA_CONTRATO + "text, " +
            " " + DISCAPACIDAD + "text, " +
            " " + SALARIO + "text, " +
            " " + HORARIO + "text)";


}
