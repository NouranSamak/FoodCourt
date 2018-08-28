package com.projects.nouran.foodcourt.main.presenter.apiconnection;

import com.projects.nouran.foodcourt.main.pojos.Store;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    //Get Request to get all stores from the API.
    @GET("stores.json")
    Call<List<Store>> getStores();

}
