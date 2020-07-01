package com.cheryl.petit;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class settings extends AppCompatActivity {
    private ImageButton back;
    private Button opinion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //監聽器
        back = findViewById(R.id.back);
        opinion = findViewById(R.id.opinion);

        //返回鍵
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(settings.this, homepage.class);
                startActivity(intent);
            }
        });
        //意見回饋
        opinion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(settings.this, opinion.class);
                startActivity(intent);
            }
        });
    }

}
