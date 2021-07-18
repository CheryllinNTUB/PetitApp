package com.cheryl.petit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;


public class record extends AppCompatActivity {

    private CardView cal,doc,supp,weight;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        //裝監聽器
        cal =findViewById(R.id.cal);
        doc =findViewById(R.id.doc);
        supp =findViewById(R.id.supp);
        weight = findViewById(R.id.weight);


        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass( record.this,addcal.class);
                startActivity(intent);
            }
        });

       doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass( record.this,adddoc.class);
                startActivity(intent);
            }
        });


        supp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass( record.this,addsupp.class);
                startActivity(intent);
            }
        });

       weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass( record.this,addweight.class);
                startActivity(intent);
            }
        });

        bottomNavigationView = findViewById(R.id.bottomnavi);
        bottomNavigationView.setSelectedItemId(R.id.navi_record);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navi_article:
                        startActivity(new Intent(getApplicationContext()
                                ,homepage.class ));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.navi_search:
                        startActivity(new Intent(getApplicationContext()
                                ,search.class ));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.navi_record:

                        return true;


                    case R.id.navi_user:
                        startActivity(new Intent(getApplicationContext()
                                ,user.class ));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });


    }
}

