package com.tecktinkle.mvp_dagger.di.module;

import android.app.Application;

import com.tecktinkle.mvp_dagger.InitApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Mr. Wasir on 07,September,2018
 */
@Module
public class AppModule {
    private InitApplication initApplication;

    public AppModule(InitApplication initApplication) {
        this.initApplication = initApplication;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return initApplication;
    }
}
