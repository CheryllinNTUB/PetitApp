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

public class favorite extends AppCompatActivity {
    private ViewPager pager;
    private TabLayout tab_layout;
    private TabItem favorite_album, favorite_place;
    private ImageButton back;
    public PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        pager = (ViewPager) findViewById(R.id.pager);
        tab_layout = (TabLayout) findViewById(R.id.tab_layout);
        back = (ImageButton) findViewById(R.id.back);
        favorite_place = (TabItem) findViewById(R.id.tabplace);
        favorite_album = (TabItem) findViewById(R.id.tabalbum);


        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tab_layout.getTabCount());
        pager.setAdapter(pagerAdapter);

        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 2) {
                    pagerAdapter.notifyDataSetChanged();
                } else if (tab.getPosition() == 3) {
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab_layout));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(favorite.this, homepage.class);
                intent.putExtra("cal", 1);
                startActivity(intent);
                finish();
            }
        });

    }

}