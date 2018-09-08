package com.tecktinkle.mvp_dagger.presenter;

/**
 * Created by Mr. Wasir on 07,September,2018
 */
public interface MainContract {
    interface UserAction {
        void getNewQuote();

        void onDestroy();
    }

    interface MainView {
        void showProgress();

        void hideProgress();

        void setQuote(String message);
    }

    interface GetQuoteInteractor {
        interface OnFinishedListener {
            void onFinished(String quote);
        }

        void getQuoteMsg(OnFinishedListener onFinishedListener);
    }


}
