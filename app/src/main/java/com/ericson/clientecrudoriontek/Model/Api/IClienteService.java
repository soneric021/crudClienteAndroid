package com.ericson.clientecrudoriontek.Model.Api;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ericson.clientecrudoriontek.Model.Entities.Cliente;
import com.ericson.clientecrudoriontek.Model.Entities.ClienteDirecciones;
import com.ericson.clientecrudoriontek.Model.Entities.ResponseCliente;

import java.util.List;

public interface IClienteService {

    //online
MutableLiveData<List<ResponseCliente>> getClientes();
MutableLiveData<ResponseCliente> getCliente(int id);
void insertCliente(ResponseCliente cliente);
void updateCliente(ResponseCliente cliente);
void deleteCliente(int id);

//Offline
LiveData<List<ClienteDirecciones>> getClientesOff();
    LiveData<ClienteDirecciones> getClienteOff(int id);
    void insertCliente(Cliente cliente);
    void updateCliente(Cliente cliente);
    void deleteClienteOff(Cliente cliente);

}
