package com.example.examen;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterEmpleados extends RecyclerView.Adapter<AdapterEmpleados.ViewHolderDatos> {

    ArrayList<Empleados> listado;

    public AdapterEmpleados(ArrayList<Empleados> listado){
        this.listado = listado;
    }


    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listado, null, false);
        return new ViewHolderDatos(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.txtCedula.setText(listado.get(position).getCedula());
        holder.txtNombres.setText(listado.get(position).getNombres());
        holder.txtApellidos.setText(listado.get(position).getApellidos());
        holder.txtFechaContrato.setText(listado.get(position).getFechaContrato());
        holder.txtCedula.setText(listado.get(position).getSalario());
        holder.txtCedula.setText(listado.get(position).getDiscapacidad());
        holder.txtCedula.setText(listado.get(position).getHorario());
    }


    @Override
    public int getItemCount() {
        return listado.size();
    }


    public class ViewHolderDatos extends RecyclerView.ViewHolder{

        TextView txtCedula, txtNombres, txtApellidos, txtFechaContrato, txtSalario, txtDiscapacidad, txtHorario;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            txtCedula = itemView.findViewById(R.id.txtCedulaEditar);
            txtNombres = itemView.findViewById(R.id.txtNombresEditar);
            txtApellidos = itemView.findViewById(R.id.txtApellidosEditar);
            txtFechaContrato = itemView.findViewById(R.id.txtFechaContratoEditar);
            txtSalario = itemView.findViewById(R.id.txtSalarioEditar);
            txtDiscapacidad = itemView.findViewById(R.id.txtDiscapacidadEditar);
            txtHorario = itemView.findViewById(R.id.txtHorarioEditar);
        }
    }


}

