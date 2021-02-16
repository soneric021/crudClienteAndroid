package com.ericson.clientecrudoriontek.Model.Api;

import androidx.room.Delete;

import com.ericson.clientecrudoriontek.Model.Entities.Cliente;
import com.ericson.clientecrudoriontek.Model.Entities.ResponseCliente;
import com.ericson.clientecrudoriontek.Model.Entities.ResponseClientes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface RestApi {
    @GET("api/cliente")
     Call<List<ResponseCliente>> getClientes();

    @GET("api/cliente/{clienteid}")
     Call<ResponseCliente> getCliente(@Path("clienteid") int clienteid);

    @POST("api/cliente")
    Call<ResponseCliente> postClinte(@Body ResponseCliente cliente  );

    @PUT("api/cliente")
    Call<ResponseCliente> putCliente(@Body ResponseCliente cliente);

    @DELETE("api/cliente/{clienteid}")
    Call<ResponseCliente> deleteCliente(@Path("clienteid") int clienteid);
}
