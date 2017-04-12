package com.orbismobile.betasearch.ui.activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.orbismobile.betasearch.R;
import com.orbismobile.betasearch.data.ViewPagerAdapter;

public class TabActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private EditText txtSearch;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_tab);

        initUI();

    }

    private void initUI() {
        final ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        txtSearch = (EditText) findViewById(R.id.txtSearch);
        txtSearch.setOnClickListener(this);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                //tabLayout.getTabAt(0).setText("Búsquedas");
                tabLayout.getTabAt(0).setIcon(R.drawable.ic_search);

                //tabLayout.getTabAt(1).setText("Postulaciones");
                tabLayout.getTabAt(1).setIcon(R.drawable.ic_postulation);

                //tabLayout.getTabAt(2).setText("Notificaciones");
                tabLayout.getTabAt(2).setIcon(R.drawable.ic_notification);

                //tabLayout.getTabAt(3).setText("Perfil");
                tabLayout.getTabAt(3).setIcon(R.drawable.ic_perfil);
            }
        });


    }


    @Override
    public void onClick(View v) {
        startActivity(new Intent(TabActivity.this, SearchActivity.class));
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }
}
