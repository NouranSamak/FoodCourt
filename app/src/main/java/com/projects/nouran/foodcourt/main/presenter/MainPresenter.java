package com.projects.nouran.foodcourt.main.presenter;

import com.projects.nouran.foodcourt.main.MainContract;

public class MainPresenter implements MainContract.MvpPresenter {

    private MainContract.MvpView mView;

    public MainPresenter(MainContract.MvpView view) {
        mView = view;
    }


}
