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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cliente);
        txtNombre = (EditText) findViewById(R.id.editName);
        editFecha = findViewById(R.id.editFecha);
        editTelefono = (EditText) findViewById(R.id.editTelefono);
        editDireccion = findViewById(R.id.editDireccion);
        btnGuardar = findViewById(R.id.btnGuardar);
        Cliente cliente = new Cliente();
        String name = txtNombre.getText().toString();
        cliente.setName(name);
        String fecha = editFecha.getYear() + "-" + editFecha.getMonth() + "-" + editFecha.getDayOfMonth();
        cliente.setFechaNac(fecha);
        String telefono = editTelefono.getText().toString();
        cliente.setTelefono(telefono);
       // cliente.getDirecciones().add(new Direccion(editDireccion.getText().toString()));

        clienteViewModel = new ViewModelProvider(this).get(ClienteViewModel.class);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clienteViewModel.getClienteService().insertCliente(cliente);
            }
        });
    }
}