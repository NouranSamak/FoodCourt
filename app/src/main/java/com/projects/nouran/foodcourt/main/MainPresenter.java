package com.projects.nouran.foodcourt.main;

public class MainPresenter implements MainContract.MvpPresenter{

    private MainContract.MvpView mView;

    MainPresenter(MainContract.MvpView view) {
        mView = view;
    }

}
