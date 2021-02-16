package com.ericson.clientecrudoriontek.View.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.ericson.clientecrudoriontek.Model.Entities.Cliente;
import com.ericson.clientecrudoriontek.Model.Entities.Direccion;
import com.ericson.clientecrudoriontek.Model.Entities.ResponseCliente;
import com.ericson.clientecrudoriontek.R;
import com.ericson.clientecrudoriontek.ViewModel.ClienteViewModel;

public class AddClienteActivity extends AppCompatActivity {

    private ClienteViewModel clienteViewModel;
    private EditText txtNombre;
    private EditText editTelefono;
    private EditText editDireccion;
    private DatePicker editFecha;
    private Button btnGuardar;
    private Button btnEliminar;
    private Cliente clienteEl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cliente);
        txtNombre = (EditText) findViewById(R.id.editName);
        editFecha = findViewById(R.id.editFecha);
        editTelefono = (EditText) findViewById(R.id.editTelefono);
        editDireccion = findViewById(R.id.editDireccion);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnEliminar = findViewById(R.id.btnBorrar);
        int idCliente = getIntent().getIntExtra("idCliente", 0);
       // cliente.getDirecciones().add(new Direccion(editDireccion.getText().toString()));

        clienteViewModel = new ViewModelProvider(this).get(ClienteViewModel.class);
        clienteViewModel.getListClienteOff().observe(this, clienteDirecciones -> {
                    if(idCliente != 0){
                        clienteEl = clienteDirecciones.get(0).cliente;
                        btnGuardar.setText("Editar");
                        btnEliminar.setVisibility(View.VISIBLE);
                        txtNombre.setText(clienteEl.getName());
                        editTelefono.setText(clienteEl.getTelefono());
                    }
                }

                );
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cliente cliente = new Cliente();
                String name = txtNombre.getText().toString();
                cliente.setName(name);
                String fecha = editFecha.getYear() + "-" + editFecha.getMonth() + "-" + editFecha.getDayOfMonth();
                cliente.setFechaNac(fecha);
                String telefono = editTelefono.getText().toString();
                cliente.setTelefono(telefono);
                if(idCliente != 0){
                    clienteViewModel.getClienteService().updateCliente(cliente);
                }else{
                    clienteViewModel.getClienteService().insertCliente(cliente);
                }
            }
        });
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            clienteViewModel.getClienteService().deleteClienteOff(clienteEl);
            onBackPressed();
            }
        });
    }
}