package com.example.saurabh.iblive.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.saurabh.iblive.R;
import com.example.saurabh.iblive.fragment.DiscoverFragment;

/**
 * home activity contains side menu and container for fragment
 */
public class HomeActivity extends AppCompatActivity {
    private TextView tvDrawer;
    private ImageButton  ibGrid;
    private DrawerLayout mDrawer;
    private TextView tvTitle, tvHome, tvCards, tvlogout, tvNetworks, tvSupport, tvShare;
    private Toolbar toolbar;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
       tvDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                mDrawer.openDrawer(Gravity.START);
            }
        });
        DiscoverFragment discoverFragment = new DiscoverFragment();
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, discoverFragment);
        fragmentTransaction.commit();
    }

    private void init() {
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ibGrid = (ImageButton) findViewById(R.id.ib_grid);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvHome = (TextView) findViewById(R.id.tv_home);
        tvCards = (TextView) findViewById(R.id.tv_cards);
        tvlogout = (TextView) findViewById(R.id.tv_logout);
        tvNetworks =(TextView) findViewById(R.id.tv_network);
        tvShare = (TextView) findViewById(R.id.tv_share);
        tvSupport =(TextView) findViewById(R.id.tv_support);
        toolbar = (Toolbar) findViewById(R.id.custom_toolbar);
        tvDrawer = (TextView) findViewById(R.id.tv_drawer);

    }
    public Toolbar getToolbar(){
        return toolbar;
    }
}
