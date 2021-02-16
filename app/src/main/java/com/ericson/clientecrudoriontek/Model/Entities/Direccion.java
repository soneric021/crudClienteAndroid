package com.ericson.clientecrudoriontek.Model.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Direccion {
    public Direccion(String name){
        this.name = name;
    }
    @PrimaryKey
    private int id;
    private String name;
    private int clienteid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClienteid() {
        return clienteid;
    }

    public void setClienteid(int clienteid) {
        this.clienteid = clienteid;
    }
}
