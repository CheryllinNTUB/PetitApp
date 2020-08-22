package com.cheryl.petit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class gallery extends AppCompatActivity {


    private ImageButton add_photo;
        private CardView add_photocard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

            add_photo = findViewById(R.id.add_photo);
            add_photocard = findViewById(R.id.add_photocard);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnavi);
        bottomNavigationView.setSelectedItemId(R.id.album);

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


            //加入相簿日記鍵
            add_photo.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(gallery.this,addalbum.class);
            startActivity(intent);
        }
    });


        //加入相簿日記鍵
        add_photocard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(gallery.this,addalbum.class);
                startActivity(intent);
            }
        });
        }



    }
