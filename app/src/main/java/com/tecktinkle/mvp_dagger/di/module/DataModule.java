package com.tecktinkle.mvp_dagger.di.module;

import com.tecktinkle.mvp_dagger.model.GetQuoteInteractorImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Mr. Wasir on 07,September,2018
 */
@Module
public class DataModule {

    @Provides
    public GetQuoteInteractorImpl provideModelClass() {
        return new GetQuoteInteractorImpl();
    }
}
