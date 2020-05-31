package com.cheryl.petit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

public class park extends AppCompatActivity {
    private ImageButton back;
    private Spinner city,reigon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park);
        back = findViewById(R.id.back);
        city = findViewById(R.id.city);
        reigon = findViewById(R.id.region);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.custom_spinner,
                getResources().getStringArray(R.array.list)
        );


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(park.this,homepage.class);
                intent.putExtra("park",9);
                startActivity(intent);
                finish();
            }
        });
    }
}
