package com.ericson.clientecrudoriontek.Model.Api;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ericson.clientecrudoriontek.Model.Database.ClienteDao;
import com.ericson.clientecrudoriontek.Model.Database.ClienteDatabase;
import com.ericson.clientecrudoriontek.Model.Entities.Cliente;
import com.ericson.clientecrudoriontek.Model.Entities.ClienteDirecciones;
import com.ericson.clientecrudoriontek.Model.Entities.ResponseCliente;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClienteService implements IClienteService {
    private RestApi api;
    private ClienteDao clienteDao;
    private LiveData<List<Cliente>> clientes;
   public ClienteService(Application application){
       OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
       HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
       loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
       clientBuilder.addInterceptor(loggingInterceptor);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:44337/")
                .client(clientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ClienteDatabase clienteDatabase = ClienteDatabase.getInstance(application);
        clienteDao = clienteDatabase.clienteDao();
        api = retrofit.create(RestApi.class);
    }


    @Override
    public MutableLiveData<List<ResponseCliente>> getClientes() {
        final MutableLiveData<List<ResponseCliente>> listclientes = new MutableLiveData<>();
        api.getClientes().enqueue(new Callback<List<ResponseCliente>>(){

            @Override
            public void onResponse(Call<List<ResponseCliente>> call, Response<List<ResponseCliente>> response) {
                if(response.isSuccessful()){
                 listclientes.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<ResponseCliente>> call, Throwable t) {
                listclientes.setValue(null);
            }
        });
        return  listclientes;
    }

    @Override
    public MutableLiveData<ResponseCliente> getCliente(int id) {
        final MutableLiveData<ResponseCliente> cliente = new MutableLiveData<>();
        api.getCliente(id).enqueue(new Callback<ResponseCliente>(){

            @Override
            public void onResponse(Call<ResponseCliente> call, Response<ResponseCliente> response) {
                if(response.isSuccessful()){
                    cliente.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ResponseCliente> call, Throwable t) {
                cliente.setValue(null);
            }
        });
        return  cliente;
    }

    @Override
    public void insertCliente(ResponseCliente cliente) {
        final MutableLiveData<ResponseCliente> clienter = new MutableLiveData<>();
        api.postClinte(cliente).enqueue(new Callback<ResponseCliente>(){

            @Override
            public void onResponse(Call<ResponseCliente> call, Response<ResponseCliente> response) {
                if(response.isSuccessful()){
                    clienter.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ResponseCliente> call, Throwable t) {
                clienter.setValue(null);
            }
        });
    }

    @Override
    public void updateCliente(ResponseCliente cliente) {
        final MutableLiveData<ResponseCliente> clienter = new MutableLiveData<>();
        api.putCliente(cliente).enqueue(new Callback<ResponseCliente>(){

            @Override
            public void onResponse(Call<ResponseCliente> call, Response<ResponseCliente> response) {
                if(response.isSuccessful()){
                    clienter.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ResponseCliente> call, Throwable t) {
                clienter.setValue(null);
            }
        });
    }

    @Override
    public void deleteCliente(int id) {
        final MutableLiveData<ResponseCliente> clienter = new MutableLiveData<>();
        api.deleteCliente(id).enqueue(new Callback<ResponseCliente>(){

            @Override
            public void onResponse(Call<ResponseCliente> call, Response<ResponseCliente> response) {
                if(response.isSuccessful()){
                    clienter.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ResponseCliente> call, Throwable t) {
                clienter.setValue(null);
            }
        });
    }

    @Override
    public LiveData<List<ClienteDirecciones>> getClientesOff() {

       return clienteDao.getAll();
    }

    @Override
    public LiveData<ClienteDirecciones> getClienteOff(int id) {
       return clienteDao.getById(id);
    }

    @Override
    public void insertCliente(Cliente cliente) {
        new InsertClienteAsync(clienteDao).execute(cliente);
    }
    private static class InsertClienteAsync extends AsyncTask<Cliente, Void, Void>{
       private ClienteDao clienteDao;
        private  InsertClienteAsync(ClienteDao clienteDao){
            this.clienteDao = clienteDao;
        }
        @Override
        protected Void doInBackground(Cliente... clientes) {
            this.clienteDao.insert(clientes[0]);
            return null;
        }
    }

    @Override
    public void updateCliente(Cliente cliente) {
        new updateClienteAsync(clienteDao).execute(cliente);
    }
    private static class updateClienteAsync extends AsyncTask<Cliente, Void, Void>{
        private ClienteDao clienteDao;
        private  updateClienteAsync(ClienteDao clienteDao){
            this.clienteDao = clienteDao;
        }
        @Override
        protected Void doInBackground(Cliente... clientes) {
            this.clienteDao.update(clientes[0]);
            return null;
        }
    }
    @Override
    public void deleteClienteOff(Cliente cliente) {
        new DeleteClienteAsync(clienteDao).execute(cliente);
    }
    private static class DeleteClienteAsync extends AsyncTask<Cliente, Void, Void>{
        private ClienteDao clienteDao;
        private   DeleteClienteAsync(ClienteDao clienteDao){
            this.clienteDao = clienteDao;
        }
        @Override
        protected Void doInBackground(Cliente... clientes) {
            this.clienteDao.delete(clientes[0]);
            return null;
        }
    }
}
