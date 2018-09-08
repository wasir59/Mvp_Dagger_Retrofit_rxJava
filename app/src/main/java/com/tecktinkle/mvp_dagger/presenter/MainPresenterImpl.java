package com.tecktinkle.mvp_dagger.presenter;

import android.annotation.SuppressLint;
import android.support.v4.util.Preconditions;


/**
 * Created by Mr. Wasir on 07,September,2018
 */
public class MainPresenterImpl implements MainContract.UserAction {
    private MainContract.MainView mainView;
    private MainContract.GetQuoteInteractor getQuoteInteractor;

    @SuppressLint("RestrictedApi")
    public MainPresenterImpl(MainContract.MainView mainView, MainContract.GetQuoteInteractor getQuoteInteractor) {
        this.mainView = Preconditions.checkNotNull(mainView);
        this.getQuoteInteractor = Preconditions.checkNotNull(getQuoteInteractor);
    }

    @Override
    public void getNewQuote() {
        mainView.showProgress();
        getQuoteInteractor.getQuoteMsg(new MainContract.GetQuoteInteractor.OnFinishedListener() {
            @Override
            public void onFinished(String quote) {
                mainView.setQuote(quote);
                mainView.hideProgress();
            }
        });
    }

    @Override
    public void onDestroy() {
        mainView = null;
        getQuoteInteractor = null;
    }
}
