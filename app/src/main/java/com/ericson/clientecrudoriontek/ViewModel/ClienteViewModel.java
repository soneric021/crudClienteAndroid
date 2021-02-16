package com.ericson.clientecrudoriontek.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ericson.clientecrudoriontek.Model.Api.ClienteService;
import com.ericson.clientecrudoriontek.Model.Entities.Cliente;
import com.ericson.clientecrudoriontek.Model.Entities.ClienteDirecciones;
import com.ericson.clientecrudoriontek.Model.Entities.ResponseCliente;
import com.ericson.clientecrudoriontek.Model.Entities.ResponseClientes;

import java.util.List;

public class ClienteViewModel extends AndroidViewModel {
    private ClienteService clienteService;
    private LiveData<List<ResponseCliente>> listCliente = new MutableLiveData<>();
    private LiveData<List<ClienteDirecciones>> listClienteoff = new MutableLiveData<>();
    private MutableLiveData<ResponseCliente> cliente = new MutableLiveData<>();
    public ClienteViewModel(@NonNull Application application) {
        super(application);
        clienteService = new ClienteService(application);
    }

    public LiveData<List<ResponseCliente>> getListCliente(){
        listCliente =  clienteService.getClientes();
        return listCliente;
    }
    public LiveData<ResponseCliente> getCliente(int id){
        cliente =  clienteService.getCliente(id);
        return cliente;
    }

    public ClienteService getClienteService() {
        return clienteService;
    }
    public LiveData<List<ClienteDirecciones>> getListClienteOff(){
        listClienteoff = clienteService.getClientesOff();
        return  listClienteoff;
    }
}
