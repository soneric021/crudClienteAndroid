package com.ericson.clientecrudoriontek.Model.Entities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResponseCliente {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("telefono")
    private String telefono;
    @SerializedName("fechaNac")
    private String fechaNac;

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    @SerializedName("direcciones")
    private List<Direccion> direcciones;


    // Getter Methods

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    // Setter Methods

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }
}
