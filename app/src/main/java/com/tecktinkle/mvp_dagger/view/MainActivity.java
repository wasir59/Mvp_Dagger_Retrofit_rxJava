package com.tecktinkle.mvp_dagger.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tecktinkle.mvp_dagger.InitApplication;
import com.tecktinkle.www.mvp_dagger.R;
import com.tecktinkle.mvp_dagger.di.component.AppComponent;
import com.tecktinkle.mvp_dagger.di.component.DaggerActivityComponent;
import com.tecktinkle.mvp_dagger.di.module.MvpModule;
import com.tecktinkle.mvp_dagger.model.GetQuoteInteractorImpl;
import com.tecktinkle.mvp_dagger.presenter.MainContract;
import com.tecktinkle.mvp_dagger.presenter.MainPresenterImpl;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    private ProgressBar progressBar;
    private TextView textView;
    private Button button;
    @Inject
    MainContract.UserAction presenter;
    @Inject
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();

        DaggerActivityComponent.builder().appComponent(InitApplication.get(this).getComponent()).mvpModule(new MvpModule(this)).build().inject(this);
        presenter.getNewQuote();
    }

    private void initUI() {
        progressBar = findViewById(R.id.progressBar2);
        textView = findViewById(R.id.textView2);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getNewQuote();
            }
        });
    }

    @Override
    public void showProgress() {
        if (progressBar != null && !progressBar.isShown()) {
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideProgress() {
        if (progressBar != null && progressBar.isShown()) {
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void setQuote(String message) {
        textView.setText(message);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();

    }
}
