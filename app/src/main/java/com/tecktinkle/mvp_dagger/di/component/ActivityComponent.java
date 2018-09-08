package com.tecktinkle.mvp_dagger.di.component;

import com.tecktinkle.mvp_dagger.di.module.MvpModule;
import com.tecktinkle.mvp_dagger.di.scope.ActivityScope;
import com.tecktinkle.mvp_dagger.presenter.MainContract;
import com.tecktinkle.mvp_dagger.view.MainActivity;

import dagger.Component;

/**
 * Created by Mr. Wasir on 07,September,2018
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = MvpModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);

    MainContract.UserAction getMainPresenter();
}
