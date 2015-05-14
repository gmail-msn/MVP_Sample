package com.demo.koolcloud.mvptest.interactors;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;

import com.demo.koolcloud.mvptest.R;
import com.demo.koolcloud.mvptest.ui.main.OnFinishedListener;

import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 2015/5/14.
 */
public class FindItemsInteractorImpl implements FindItemsInteractor {

    @Override
    public void findItems(final OnFinishedListener listener, final Activity context) {

        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                listener.onFinished(createArrayList(context));
            }
        }, 2000);
    }

    private List<String> createArrayList(Activity context) {
        Resources res = context.getResources();
        return Arrays.asList(res.getStringArray(R.array.smartpos_interfaces));
    }
}
