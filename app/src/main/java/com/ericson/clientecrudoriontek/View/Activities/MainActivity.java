package com.ericson.clientecrudoriontek.View.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ericson.clientecrudoriontek.R;
import com.ericson.clientecrudoriontek.View.Adapters.ClienteAdapter;
import com.ericson.clientecrudoriontek.ViewModel.ClienteViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private ClienteViewModel clienteViewModel;
    private RecyclerView recyclerView;
    private FloatingActionButton btnAgregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvClientes);
        btnAgregar = findViewById(R.id.btnAgregar);
        clienteViewModel = new ViewModelProvider(this).get(ClienteViewModel.class);
        clienteViewModel.getListClienteOff().observe(this, clientes -> {

            recyclerView.setLayoutManager(new LinearLayoutManager(this));
           recyclerView.setAdapter(new ClienteAdapter(this, clientes));
        });

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AddClienteActivity.class);
                startActivity(intent);
            }
        });

    }
}