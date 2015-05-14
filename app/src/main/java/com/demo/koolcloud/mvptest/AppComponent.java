package com.demo.koolcloud.mvptest;


import com.demo.koolcloud.mvptest.domain.AnalyticsManager;
import com.demo.koolcloud.mvptest.domain.DomainModule;
import com.demo.koolcloud.mvptest.interactors.FindItemsInteractor;
import com.demo.koolcloud.mvptest.interactors.InteractorsModule;
import com.demo.koolcloud.mvptest.interactors.LoginInteractor;
import com.demo.koolcloud.mvptest.interactors.ShowInteractor;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Miroslaw Stanek on 17.03.15.
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                DomainModule.class,
                InteractorsModule.class
        }
)
public interface AppComponent {
    void inject(App app);

    AnalyticsManager getAnalyticsManager();
    LoginInteractor getLoginInteractor();
    FindItemsInteractor getFindItemsInteractor();
    ShowInteractor getShowInteractor();
}
