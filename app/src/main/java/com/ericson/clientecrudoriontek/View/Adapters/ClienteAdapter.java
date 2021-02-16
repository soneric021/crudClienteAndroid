package com.ericson.clientecrudoriontek.View.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ericson.clientecrudoriontek.Model.Entities.ClienteDirecciones;
import com.ericson.clientecrudoriontek.Model.Entities.ResponseCliente;
import com.ericson.clientecrudoriontek.Model.Entities.ResponseClientes;
import com.ericson.clientecrudoriontek.R;
import com.ericson.clientecrudoriontek.View.Activities.AddClienteActivity;

import java.util.List;

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.Viewholder> {
    private Context _context;
    private List<ClienteDirecciones> _clientes;
    public ClienteAdapter(Context context, List<ClienteDirecciones>  clientes){
        _context = context;
        _clientes = clientes;
    }
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       return new Viewholder( LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_clientes, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        ClienteDirecciones data = _clientes.get(position);
        holder.tvNombre.setText(data.cliente.getName());
        holder.tvTelefono.setText(data.cliente.getTelefono());
        holder.tvFecha.setText(data.cliente.getFechaNac());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(_context, AddClienteActivity.class);
                intent.putExtra("idCliente", data.cliente.getId());
                _context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return _clientes.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView tvNombre;
        TextView tvFecha;
        TextView tvTelefono;
        Viewholder(View itemview){
            super(itemview);
             tvNombre = itemview.findViewById(R.id.txtname);
             tvFecha = itemview.findViewById(R.id.txtfecha);
             tvTelefono = itemview.findViewById(R.id.txttelefono);
        }
    }
}
