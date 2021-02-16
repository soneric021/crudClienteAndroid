package com.ericson.clientecrudoriontek.Model.Entities;

import java.util.List;

public class ResponseClientes {
    private  List<ResponseCliente> clientes;

    public List<ResponseCliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<ResponseCliente> clientes) {
        this.clientes = clientes;
    }
}
