package com.projects.nouran.foodcourt.main.view;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.projects.nouran.foodcourt.R;
import com.projects.nouran.foodcourt.main.MainContract;
import com.projects.nouran.foodcourt.main.RecyclerViewAdapter;
import com.projects.nouran.foodcourt.main.presenter.apiconnection.ApiClient;
import com.projects.nouran.foodcourt.main.presenter.apiconnection.ApiInterface;
import com.projects.nouran.foodcourt.main.pojos.Store;
import com.projects.nouran.foodcourt.main.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

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

    private EditText filterStores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPresenter = new MainPresenter(this);

        filterStores = (EditText) findViewById(R.id.searchStores);
        recyclerView = (RecyclerView) findViewById(R.id.storesList);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        //Adding a divider item to the list.
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<Store>> call = apiInterface.getStores();

        call.enqueue(new Callback<List<Store>>() {
            @Override
            public void onResponse(Call<List<Store>> call, Response<List<Store>> response) {
                stores = response.body();
                recyclerViewAdapter = new RecyclerViewAdapter(stores, MainActivity.this);
                recyclerView.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<List<Store>> call, Throwable t) {
                System.out.println("------------------- Failure Message ------------------- " + t.getMessage());
            }
        });



        // Filter the stores list
        filterStores.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            //A listener on the filter search box.
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                List<Store> filteredList = new ArrayList<>();
                if (!charSequence.equals("")) {
                    filteredList = mainPresenter.filterStores(stores, filterStores.getText().toString());
                    recyclerViewAdapter.setStores(filteredList);
                    recyclerViewAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    //Check if the device is rotated.
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerViewAdapter.isPortrait(true);
            recyclerViewAdapter.notifyDataSetChanged();
        } else {
            recyclerViewAdapter.isPortrait(false);
            recyclerViewAdapter.notifyDataSetChanged();
        }
    }
}
