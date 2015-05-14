package com.demo.koolcloud.mvptest.ui.show;


import com.demo.koolcloud.mvptest.ActivityScope;
import com.demo.koolcloud.mvptest.AppComponent;

import dagger.Component;

/**
 * Created by Miroslaw Stanek on 17.03.15.
 */
@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = ShowModule.class
)
public interface ShowComponent {
    void inject(ShowActivity activity);

    ShowPresenter getLoginPresenter();
}
