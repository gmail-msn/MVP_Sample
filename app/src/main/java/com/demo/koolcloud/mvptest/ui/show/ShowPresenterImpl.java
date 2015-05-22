
package com.demo.koolcloud.mvptest.ui.show;


import android.app.Activity;

import com.demo.koolcloud.mvptest.interactors.ShowInteractor;

public class ShowPresenterImpl implements ShowPresenter, ShowResultListener {

    private ShowView showView;
    private ShowInteractor showInteractor;
    private Activity context;

    public ShowPresenterImpl(ShowView showView, ShowInteractor showInteractor) {
        this.showView = showView;
        this.showInteractor = showInteractor;
    }

    @Override
    public void onResume(Activity context, int position) {
        this.context = context;
        showView.showProgress();
        showInteractor.showResultMessage(this, context, position);
    }

    @Override
    public void showResultMessage(String message) {
        this.showView.showMessage(message);
        showView.hideProgress();
    }
}
