package com.ericson.clientecrudoriontek.Model.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.ericson.clientecrudoriontek.Model.Entities.Cliente;
import com.ericson.clientecrudoriontek.Model.Entities.Direccion;

@Database(entities ={Cliente.class, Direccion.class}, version = 1)
public abstract class ClienteDatabase extends RoomDatabase {
    private static ClienteDatabase instance;

    public abstract ClienteDao clienteDao();

    public static synchronized ClienteDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    ClienteDatabase.class, "cliente_database"
            ).fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }


}
