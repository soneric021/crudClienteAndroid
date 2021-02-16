package com.ericson.clientecrudoriontek.Model.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.ericson.clientecrudoriontek.Model.Entities.Cliente;
import com.ericson.clientecrudoriontek.Model.Entities.ClienteDirecciones;

import java.util.List;
@Dao
public interface ClienteDao {
    @Transaction
    @Query("SELECT * FROM cliente")
    LiveData<List<ClienteDirecciones>> getAll();

    @Transaction
    @Query("SELECT * FROM cliente WHERE id IN (:clienteids)")
    LiveData<List<ClienteDirecciones>> loadAllByIds(int[] clienteids);

    @Transaction
    @Query("SELECT * FROM cliente WHERE id = :id")
    LiveData<ClienteDirecciones> getById(int id);

    @Insert
    void insertAll(Cliente... users);

    @Insert
    void insert(Cliente cliente);
    @Update
    void update(Cliente cliente);

    @Delete
    void delete(Cliente user);
}
