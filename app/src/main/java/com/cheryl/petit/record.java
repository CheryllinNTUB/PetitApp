package com.cheryl.petit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class record extends AppCompatActivity {

    private CardView cal,doc,supp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        //裝監聽器
        cal =findViewById(R.id.cal);
        doc =findViewById(R.id.doc);
        supp =findViewById(R.id.supp);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnavi);
        bottomNavigationView.setSelectedItemId(R.id.record);

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

    }
}

