package com.cheryl.petit;


import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;


public class favorite extends AppCompatActivity {
    private  ViewPager pager;
    private TabLayout tab_layout;
    private TabItem tabplace,tabalbum;
    public PagerAdapter pagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);


        tab_layout =(TabLayout) findViewById(R.id.tab_layout);
        tabplace =(TabItem)findViewById(R.id.tabplace);
        tabalbum=(TabItem)findViewById(R.id.tabalbum);
        pager = findViewById(R.id.pager);

        pagerAdapter  = new PageAdapter(getSupportFragmentManager(),tab_layout.getTabCount());
        pager.setAdapter(pagerAdapter);


        tab_layout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 0) {
                    pagerAdapter.notifyDataSetChanged();
                }
                    if(tab.getPosition() == 1){
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
    }
}
