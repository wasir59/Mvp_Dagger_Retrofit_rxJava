package com.tecktinkle.mvp_dagger.di.module;

import com.tecktinkle.mvp_dagger.model.GetQuoteInteractorImpl;
import com.tecktinkle.mvp_dagger.presenter.MainContract;
import com.tecktinkle.mvp_dagger.presenter.MainPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Mr. Wasir on 07,September,2018
 */
@Module
public class MvpModule {

    MainContract.MainView mainView;

    public MvpModule(MainContract.MainView mainView) {
        this.mainView = mainView;
    }

    @Provides
    public MainContract.MainView provideMainView() {
        return mainView;
    }

    @Provides
    public MainContract.UserAction provideUserAction(MainContract.MainView mainView, GetQuoteInteractorImpl getQuoteInteractor) {
        return new MainPresenterImpl(mainView, getQuoteInteractor);
    }
}
