package com.cheryl.petit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class cal extends AppCompatActivity {
    private ViewPager pager;
    private TabLayout tab_layout;
    private TabItem daily,per_meal;
    public PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal);

        tab_layout =(TabLayout) findViewById(R.id.tab_layout);
        daily =(TabItem)findViewById(R.id.daily);
        per_meal=(TabItem)findViewById(R.id.per_meal);
        pager = findViewById(R.id.pager);

        pagerAdapter  = new PageAdapter(getSupportFragmentManager(),tab_layout.getTabCount());
        pager.setAdapter(pagerAdapter);


        tab_layout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 2) {
                    pagerAdapter.notifyDataSetChanged();
                }
                if(tab.getPosition() == 3){
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
