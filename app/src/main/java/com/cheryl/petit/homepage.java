package com.cheryl.petit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import android.graphics.Color;
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
        //從卡路里計算返回紀錄頁
        int cal = getIntent().getIntExtra("cal",0);
        if(cal == 1){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer,new record())
                    .addToBackStack(null)
                    .commit(); }

        //從醫療紀錄返回紀錄頁
        int doc = getIntent().getIntExtra("doc",0);
        if(doc == 2){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer,new record())
                    .addToBackStack(null)
                    .commit(); }

        //從寵物用品返回紀錄頁
        int supp = getIntent().getIntExtra("supp",0);
        if(supp == 3){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer,new record())
                    .addToBackStack(null)
                    .commit(); }

        //從友善住宿返回紀錄頁
        int hotel = getIntent().getIntExtra("hotel",0);
        if(hotel == 4){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer,new search())
                    .addToBackStack(null)
                    .commit(); }

        //從友善餐廳返回紀錄頁
        int restaurant = getIntent().getIntExtra("restaurant",0);
        if(restaurant == 5){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer,new search())
                    .addToBackStack(null)
                    .commit(); }


        //從友善景點返回紀錄頁
        int place = getIntent().getIntExtra("place",0);
        if(place == 6){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer,new search())
                    .addToBackStack(null)
                    .commit(); }


        //從寵物醫院返回紀錄頁
        int hospital = getIntent().getIntExtra("hospital",0);
        if(hospital == 7){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer,new search())
                    .addToBackStack(null)
                    .commit(); }

        //從寵物美容院返回紀錄頁
        int salon = getIntent().getIntExtra("salon",0);
        if(salon == 8){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer,new search())
                    .addToBackStack(null)
                    .commit(); }


        //從寵物公園返回紀錄頁
        int park = getIntent().getIntExtra("park",0);
        if(park == 9){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer,new search())
                    .addToBackStack(null)
                    .commit(); }


        setContentView(R.layout.activity_homepage);
        setSupportActionBar(toolbar);


        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView nvaigationView = findViewById(R.id.navigation_view);
        nvaigationView.setNavigationItemSelectedListener(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnavi);



        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.getDrawerArrowDrawable().setColor(Color.GRAY);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomnaviMethod);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed(){

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
                             Intent intent = new Intent(homepage.this, homepage.class);
                             startActivity(intent);
                        return true;

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

