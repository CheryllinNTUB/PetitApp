package com.cheryl.petit;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class addsupp extends AppCompatActivity {
    private ImageButton back,add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addsupp);

        back =  findViewById(R.id.back);
        add =findViewById(R.id.add);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(addsupp.this,homepage.class);
                intent.putExtra("addsupp",12);
                startActivity(intent);
                finish();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(addsupp.this, supp.class);
                startActivity(intent);
            }
        });
    }
}
