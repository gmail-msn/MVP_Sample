
package com.demo.koolcloud.mvptest.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.demo.koolcloud.mvptest.AppComponent;
import com.demo.koolcloud.mvptest.R;
import com.demo.koolcloud.mvptest.ui.common.BaseActivity;
import com.demo.koolcloud.mvptest.ui.show.ShowActivity;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainView, AdapterView.OnItemClickListener {

    @Inject MainPresenter presenter;
    private ListView listView;
    private ProgressBar progressBar;

    @Override
    protected void setupComponent(AppComponent appComponent) {
        DaggerMainComponent.builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);
        listView.setOnItemClickListener(this);
        progressBar = (ProgressBar) findViewById(R.id.progress);
    }

    @Override protected void onResume() {
        super.onResume();
        presenter.onResume(this);
    }

    @Override public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        listView.setVisibility(View.INVISIBLE);
    }

    @Override public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        listView.setVisibility(View.VISIBLE);
    }

    @Override public void setItems(List<String> items) {
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));
    }

    @Override public void showMessage(int message) {
//        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        Intent mIntent = new Intent(this, ShowActivity.class);
        mIntent.putExtra("position", message);
        startActivity(mIntent);

    }

    @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        presenter.onItemClicked(position);
    }
}
