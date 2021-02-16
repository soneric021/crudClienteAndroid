package com.ericson.clientecrudoriontek.Model.Entities;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Relation;

import java.util.List;

@Entity
public class ClienteDirecciones {
    public  @Embedded Cliente cliente;
    @Relation(
            parentColumn = "id",
            entityColumn = "clienteid"
    )
    public List<Direccion> direccions;
}
