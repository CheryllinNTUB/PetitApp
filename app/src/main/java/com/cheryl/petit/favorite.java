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
    public PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        final ViewPager pager = findViewById(R.id.pager);
        TabLayout tab_layout = findViewById(R.id.tab_layout);
        TabItem favorite_place = findViewById(R.id.tabplace);
        TabItem favorite_album = findViewById(R.id.tabalbum);
        ImageButton back = findViewById(R.id.back);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(favorite.this, homepage.class);
                startActivity(intent);
            }
        });

    }

}