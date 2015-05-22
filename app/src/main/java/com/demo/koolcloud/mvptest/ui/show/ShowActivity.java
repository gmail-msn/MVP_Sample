
package com.demo.koolcloud.mvptest.ui.show;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.koolcloud.mvptest.AppComponent;
import com.demo.koolcloud.mvptest.R;
import com.demo.koolcloud.mvptest.ui.common.BaseActivity;

import javax.inject.Inject;

public class ShowActivity extends BaseActivity implements ShowView {

    @Inject
    ShowPresenter presenter;
    private TextView resultTextView;
    private ProgressBar progressBar;

    @Override
    protected void setupComponent(AppComponent appComponent) {
        DaggerShowComponent.builder()
                .appComponent(appComponent)
                .showModule(new ShowModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        resultTextView = (TextView) findViewById(R.id.resultTextView);
        progressBar = (ProgressBar) findViewById(R.id.progress);
    }

    @Override protected void onResume() {
        super.onResume();
        Integer position = getIntent().getIntExtra("position", 1);
        presenter.onResume(this, position);
    }

    @Override public void showMessage(String message) {
        resultTextView.setText(message);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }
}
