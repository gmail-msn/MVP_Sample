
package com.demo.koolcloud.mvptest.ui.main;


import android.app.Activity;

import com.demo.koolcloud.mvptest.interactors.FindItemsInteractor;

import java.util.List;

public class MainPresenterImpl implements MainPresenter, OnFinishedListener {

    private MainView mainView;
    private FindItemsInteractor findItemsInteractor;

    public MainPresenterImpl(MainView mainView, FindItemsInteractor findItemsInteractor) {
        this.mainView = mainView;
        this.findItemsInteractor = findItemsInteractor;
    }

    @Override public void onResume(Activity context) {
        mainView.showProgress();
        findItemsInteractor.findItems(this, context);
    }

    @Override public void onItemClicked(int position) {
        mainView.showMessage(position + 1);
    }

    @Override public void onFinished(List<String> items) {
        mainView.setItems(items);
        mainView.hideProgress();
    }
}
