package com.cheryl.petit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import android.content.Intent;

public class homepage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        setSupportActionBar(toolbar);


        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView nvaigationView = findViewById(R.id.navigation_view);
        nvaigationView.setNavigationItemSelectedListener(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnavi);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomnaviMethod);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed(){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.personal:
                Intent intent = new Intent(homepage.this,personal.class);
                startActivity(intent);
                break;

            case R.id.pet:
                Intent intent2 = new Intent(homepage.this,pet.class);
                startActivity(intent2);
                break;

            case R.id.favorite:
                Intent intent3 = new Intent(homepage.this,favorite.class);
                startActivity(intent3);
                break;

            case R.id.settings:
                Intent intent4 = new Intent(homepage.this,settings.class);
                startActivity(intent4);
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }



     private BottomNavigationView.OnNavigationItemSelectedListener bottomnaviMethod=new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                 @Override
                 public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                     Fragment fragment = null;

                     switch (menuItem.getItemId())
                     {
                         case R.id.home:
                         fragment = new home();
                         break;

                         case R.id.search:
                         fragment =new search();
                         break;

                         case R.id.record:
                             fragment =new record();
                             break;

                         case R.id.album:
                             fragment =new album();
                             break;

                         case R.id.help:
                            fragment = new help();
                             break;


                     }
                     getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,fragment).commit();

                      return true;
                 }
             };
   }

