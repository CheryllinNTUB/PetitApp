package com.cheryl.petit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.content.Intent;
import android.view.MenuItem;
import java.util.ArrayList;

public class homepage extends AppCompatActivity {


    RecyclerView recyclerView;
    ArrayList<HelptipData> helptipDataList;
    HelptipData helptipData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        recyclerView =findViewById(R.id.recyleview);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnavi);
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        return true;

                    case R.id.search:
                        startActivity(new Intent(getApplicationContext()
                                ,search.class ));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.record:
                        startActivity(new Intent(getApplicationContext()
                                ,record.class ));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.album:
                        startActivity(new Intent(getApplicationContext()
                                , gallery.class ));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.user:
                        startActivity(new Intent(getApplicationContext()
                                ,user.class ));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        //小知識
        GridLayoutManager gridLayoutManager = new GridLayoutManager(homepage.this,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        helptipDataList = new ArrayList<>();

        helptipData = new HelptipData("關於寵物的餵食小知識...","餵對好食物，讓牠吃的快樂又安心",R.drawable.helpfood);
        helptipDataList.add(helptipData);

        helptipData = new HelptipData("關於寵物的保健小知識...","毛孩也要養生!來看牠們的保健小秘密",R.drawable.helphealth);
        helptipDataList.add(helptipData);

        helptipData = new HelptipData("關於寵物的最新活動...","最新的寵物展覽及活動資訊都在這!",R.drawable.helpnews);
        helptipDataList.add(helptipData);

        helptipData = new HelptipData("關於寵物的用品小知識...","挑對用品，主人毛孩都開心",R.drawable.helpsupplies);
        helptipDataList.add(helptipData);

        RecyleViewAdapter_help recyleViewAdapter = new RecyleViewAdapter_help(homepage.this,helptipDataList);
        recyclerView.setAdapter(recyleViewAdapter);

        }

   }

