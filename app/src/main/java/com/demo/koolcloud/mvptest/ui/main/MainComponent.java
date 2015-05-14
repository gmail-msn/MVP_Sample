package com.demo.koolcloud.mvptest.ui.main;


import com.demo.koolcloud.mvptest.ActivityScope;
import com.demo.koolcloud.mvptest.AppComponent;

import dagger.Component;

/**
 * Created by Miroslaw Stanek on 17.03.15.
 */
@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = MainModule.class
)
public interface MainComponent {
    void inject(MainActivity activity);

    MainPresenter getLoginPresenter();
}
