package com.demo.koolcloud.mvptest.interactors;

import android.app.Activity;

import com.demo.koolcloud.mvptest.ui.show.ShowResultListener;


/**
 * Created by admin on 2015/5/14.
 */
public interface ShowInteractor {

    public void showResultMessage(ShowResultListener listener, Activity context, int position);
}
