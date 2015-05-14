package com.demo.koolcloud.mvptest.ui.login;


import com.demo.koolcloud.mvptest.ActivityScope;
import com.demo.koolcloud.mvptest.AppComponent;

import dagger.Component;

/**
 * Created by Miroslaw Stanek on 17.03.15.
 */
@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = LoginModule.class
)
public interface LoginComponent {
    void inject(LoginActivity activity);

    LoginPresenter getLoginPresenter();
}