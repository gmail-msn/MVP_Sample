package com.demo.koolcloud.mvptest.interactors;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.util.Log;

import com.demo.koolcloud.mvptest.R;
import com.demo.koolcloud.mvptest.ui.main.OnFinishedListener;
import com.demo.koolcloud.mvptest.ui.show.ShowResultListener;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

import cn.koolcloud.services.SmartPosServices;

/**
 * Created by admin on 2015/5/14.
 */
public class ShowInteractorImpl implements ShowInteractor {

    @Override
    public void showResultMessage(final ShowResultListener listener, final Activity context, final int position) {
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                listener.showResultMessage(getMessage(context, position));
            }
        }, 2000);
    }

    private String getMessage(Activity context, final int position) {
        String message = "";
        SmartPosServices service = SmartPosServices.getInstance(context);
        switch (position) {
            case 1:
                JSONObject cashPayResult = service.cashPay(1000);
                message = cashPayResult.toString();
                break;
            case 2:
                JSONObject recordListObj = service.getRecordList("20150508", "20150508");
                message = recordListObj.toString();
                break;
            case 3:
                JSONObject statisticObj = service.transStatistic(0);
                message = statisticObj.toString();
                break;
            case 4:
                JSONObject merchObj = service.getMerchantInfo();
                message = merchObj.toString();
                break;
            case 5:
                JSONObject paymentObj = service.getPaymentInfo();
                message = paymentObj.toString();
                break;
            default:
                break;
        }
        Log.w("ShowInteractorImpl", message);
        return message;
    }


}
