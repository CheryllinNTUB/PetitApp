package com.cheryl.petit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class help_details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_details);

        Bundle bundle = getIntent().getExtras();

    }
}
