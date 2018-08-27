package com.projects.nouran.foodcourt.main.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.projects.nouran.foodcourt.R;
import com.projects.nouran.foodcourt.main.MainContract;
import com.projects.nouran.foodcourt.main.RecyclerViewAdapter;
import com.projects.nouran.foodcourt.main.apiconnection.ApiClient;
import com.projects.nouran.foodcourt.main.apiconnection.ApiInterface;
import com.projects.nouran.foodcourt.main.pojos.Store;
import com.projects.nouran.foodcourt.main.presenter.MainPresenter;

import java.util.List;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MainContract.MvpView {

    private MainPresenter mainPresenter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<Store> stores;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPresenter = new MainPresenter(this);

        recyclerView = (RecyclerView) findViewById(R.id.storesList);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<Store>> call = apiInterface.getStores();

        call.enqueue(new Callback<List<Store>>() {
            @Override
            public void onResponse(Call<List<Store>> call, Response<List<Store>> response) {
                stores = response.body();
                recyclerViewAdapter = new RecyclerViewAdapter(stores);
                recyclerView.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<List<Store>> call, Throwable t) {
                System.out.println("------------------- Failure -------------------");
                System.out.println("------------------- Message ------------------- " + t.getMessage());
            }
        });

    }
}