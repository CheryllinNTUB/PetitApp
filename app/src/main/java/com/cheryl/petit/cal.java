package com.cheryl.petit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import com.google.android.material.tabs.TabLayout;

public class cal extends AppCompatActivity implements ViewPager.OnPageChangeListener,
        TabLayout.OnTabSelectedListener {
    private ViewPager pager;
    private TabLayout tab_layout;
    private ImageButton back;

    private Fragment daily = new daily();
    private Fragment per_meal = new per_meal();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal);
        pager = (ViewPager) findViewById(R.id.pager);
        tab_layout = (TabLayout) findViewById(R.id.tab_layout);
        back = (ImageButton) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cal.this, homepage.class);
                intent.putExtra("cal", 1);
                startActivity(intent);
                finish();
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
                        return daily;
                    case 1:
                        return per_meal;
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





