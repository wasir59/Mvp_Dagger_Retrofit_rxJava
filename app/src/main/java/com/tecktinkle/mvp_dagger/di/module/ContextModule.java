package com.tecktinkle.mvp_dagger.di.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Mr. Wasir on 07,September,2018
 */
@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }
}
