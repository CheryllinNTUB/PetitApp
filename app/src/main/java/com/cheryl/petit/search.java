package com.cheryl.petit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class search  extends AppCompatActivity {

    private CardView park,place,hospital,salon,hotel,restaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        //裝監聽器
        park = findViewById(R.id.park);
        place = findViewById(R.id.place);
        hospital = findViewById(R.id.hospital);
        salon = findViewById(R.id.salon);
        hotel =findViewById(R.id.hotel);
        restaurant = findViewById(R.id.restaurant);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnavi);
        bottomNavigationView.setSelectedItemId(R.id.search);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                ,homepage.class ));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.search:
                        return true;

                    case R.id.record:
                        startActivity(new Intent(getApplicationContext()
                                ,record.class ));
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

        park.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass( search.this,park.class);
                startActivity(intent);
            }
        });

        place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass( search.this,place.class);
                startActivity(intent);
            }
        });

        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass( search.this,hospital.class);
                startActivity(intent);
            }
        });

        salon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass( search.this,salon.class);
                startActivity(intent);
            }
        });

       hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass( search.this,hotel.class);
                startActivity(intent);
            }
        });

        restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass( search.this,restaurant.class);
                startActivity(intent);
            }
        });

    }

}

