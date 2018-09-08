package com.tecktinkle.mvp_dagger;

import android.app.Application;
import android.content.Context;

import com.tecktinkle.mvp_dagger.di.component.AppComponent;
import com.tecktinkle.mvp_dagger.di.module.AppModule;
import com.tecktinkle.mvp_dagger.di.module.ContextModule;
import com.tecktinkle.mvp_dagger.di.module.DataModule;
import com.tecktinkle.mvp_dagger.di.component.DaggerAppComponent;

/**
 * Created by Mr. Wasir on 07,September,2018
 */
public class InitApplication extends Application {
    private AppComponent component;

    public static InitApplication get(Context context) {
        return (InitApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder().appModule(new AppModule(this)).contextModule(new ContextModule(this)).dataModule(new DataModule()).build();
    }

    public AppComponent getComponent() {
        return component;
    }
}
