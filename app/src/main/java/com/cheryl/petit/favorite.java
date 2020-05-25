package com.cheryl.petit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;

public class favorite extends AppCompatActivity implements ViewPager.OnPageChangeListener,
        TabLayout.OnTabSelectedListener {
    private  ViewPager pager;
    private TabLayout tab_layout;
    private ImageButton back;


    private Fragment favorite_place = new favorite_place();
    private Fragment favorite_album = new favorite_album();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        pager = (ViewPager) findViewById(R.id.pager);
        tab_layout = (TabLayout) findViewById(R.id.tab_layout);
        back = (ImageButton) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(favorite.this, homepage.class);
                startActivity(intent);
            }
        });


        pager.addOnPageChangeListener(this);
        tab_layout.addOnTabSelectedListener(this);

        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return favorite_place;
                    case 1:
                        return favorite_album;
                }
                return null;
            }

            @Override
            public int getCount() {
                return 2;
            }
        });

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        pager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        tab_layout.getTabAt(position).select();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

