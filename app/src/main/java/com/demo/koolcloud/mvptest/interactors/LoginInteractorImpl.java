/*
 *
 *  *
 *  *  * Copyright (C) 2014 Antonio Leiva Gordillo.
 *  *  *
 *  *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  *  * you may not use this file except in compliance with the License.
 *  *  * You may obtain a copy of the License at
 *  *  *
 *  *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *  *
 *  *  * Unless required by applicable law or agreed to in writing, software
 *  *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *  * See the License for the specific language governing permissions and
 *  *  * limitations under the License.
 *  *
 *
 */

package com.demo.koolcloud.mvptest.interactors;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import com.demo.koolcloud.mvptest.App;
import com.demo.koolcloud.mvptest.ui.login.OnLoginFinishedListener;
import com.demo.koolcloud.mvptest.util.JsonUtil;

import org.json.JSONObject;

import cn.koolcloud.services.SmartPosServices;


public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        // Mock login. I'm creating a handler to delay the answer a couple of seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.i("LoginInteractorImpl", "login");
                boolean error = false;
                if (TextUtils.isEmpty(username)){
                    listener.onUsernameError();
                    error = true;
                }
                if (TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                    error = true;
                }
                if (!error){
                    SmartPosServices service = SmartPosServices.getInstance(App.getContext());
                    JSONObject loginResult = service.login("teddy", "123456", "999290053110041");
                    Log.d("LoginInteractorImpl", loginResult.toString());

                    JSONObject jsonData = JsonUtil.getResponseData(loginResult);
                    if (null != jsonData) {
                        int responseCode = jsonData.optInt("responseCode");
                        if (responseCode == 0) {
                            listener.onSuccess();
                        } else {
                            listener.onError();;
                        }
                    }
                }
            }
        }, 2000);
    }
}
