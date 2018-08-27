package com.projects.nouran.foodcourt.main;

import com.projects.nouran.foodcourt.main.pojos.Store;

import java.util.List;

public interface MainContract {

    interface MvpView {

    }

    interface MvpPresenter {
        public List<Store> filterStores(List<Store> stores, String searchInput);
    }

}