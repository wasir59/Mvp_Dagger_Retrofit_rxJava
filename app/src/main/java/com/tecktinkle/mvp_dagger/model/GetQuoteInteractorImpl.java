package com.tecktinkle.mvp_dagger.model;

import android.os.Handler;
import android.util.Log;

import com.tecktinkle.mvp_dagger.presenter.MainContract;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


/**
 * Created by Mr. Wasir on 07,September,2018
 */
public class GetQuoteInteractorImpl implements MainContract.GetQuoteInteractor {
    private List<String> arrayList = Arrays.asList(
            "Be yourself. everyone else is already taken.",
            "A room without books is like a body without a soul.",
            "You only live once, but if you do it right, once is enough.",
            "Be the change that you wish to see in the world.",
            "If you tell the truth, you don't have to remember anything."
    );

    @Override
    public void getQuoteMsg(final OnFinishedListener onFinishedListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (onFinishedListener != null) {
                    onFinishedListener.onFinished(getRendomMsg());
                }
            }
        }, 1200);
    }

    private String getRendomMsg() {
        Random random = new Random();

        int index = random.nextInt(arrayList.size());
        Log.d("index  ", "" + index);
        return arrayList.get(index);
    }
}
