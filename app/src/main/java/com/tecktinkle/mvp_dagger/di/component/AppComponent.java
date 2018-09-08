package com.tecktinkle.mvp_dagger.di.component;

import android.app.Application;
import android.content.Context;

import com.tecktinkle.mvp_dagger.InitApplication;
import com.tecktinkle.mvp_dagger.di.module.AppModule;
import com.tecktinkle.mvp_dagger.di.module.ContextModule;
import com.tecktinkle.mvp_dagger.di.module.DataModule;
import com.tecktinkle.mvp_dagger.model.GetQuoteInteractorImpl;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Provides;

/**
 * Created by Mr. Wasir on 07,September,2018
 */
@Singleton
@Component(modules = {AppModule.class, DataModule.class, ContextModule.class})
public interface AppComponent {
    void inject(InitApplication initApplication);

    Context getContext();

    GetQuoteInteractorImpl getFindItemsInteractor();

    Application getApplication();
}
