package com.projects.nouran.foodcourt.main.presenter;

import com.projects.nouran.foodcourt.main.MainContract;
import com.projects.nouran.foodcourt.main.pojos.Store;

import java.util.List;

public class MainPresenter implements MainContract.MvpPresenter {

    private MainContract.MvpView mView;

    public MainPresenter(MainContract.MvpView view) {
        mView = view;
    }


    @Override
    public List<Store> filterStores(List<Store> stores, String searchInput) {
        return null;
    }
}
