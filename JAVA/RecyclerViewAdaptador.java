package com.example.alan.proyecto;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nombre, apellidos, telefono, email, estado;
        ImageView imgusuario;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre=(TextView)itemView.findViewById(R.id.tvnombre);
            apellidos=(TextView)itemView.findViewById(R.id.tvapellidos);
            telefono=(TextView)itemView.findViewById(R.id.tvtelefono);
            email=(TextView)itemView.findViewById(R.id.tvemail);
            estado=(TextView)itemView.findViewById(R.id.tvestado);

            imgusuario=(ImageView)itemView.findViewById(R.id.imgusuario);

        }
    }

    public List<usuarioModelo> usuarioLista;

    public RecyclerViewAdaptador(List<usuarioModelo> usuarioLista) {
        this.usuarioLista = usuarioLista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nombre.setText(usuarioLista.get(position).getNombre());
        holder.apellidos.setText(usuarioLista.get(position).getApellidos());
        holder.telefono.setText(usuarioLista.get(position).getTelefono());
        holder.email.setText(usuarioLista.get(position).getEmail());
        holder.estado.setText(usuarioLista.get(position).getEstado());
        holder.imgusuario.setImageResource(usuarioLista.get(position).getImgusuario());

    }

    @Override
    public int getItemCount() {
        return usuarioLista.size();
    }
}
