package com.demo.koolcloud.mvptest.interactors;

import android.app.Activity;

import com.demo.koolcloud.mvptest.ui.main.OnFinishedListener;

/**
 * Created by admin on 2015/5/14.
 */
public interface FindItemsInteractor {

    public void findItems(OnFinishedListener listener, Activity context);
}
