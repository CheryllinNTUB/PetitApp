package com.cheryl.petit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Quizscore extends AppCompatActivity {

    private TextView score,total;
    private Button finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizscore);

        score = findViewById(R.id.score);
        total = findViewById(R.id.total);
        finish = findViewById(R.id.finish);

        score.setText(String.valueOf(getIntent().getIntExtra("score",0)));
        total.setText("滿分為:" +String.valueOf(getIntent().getIntExtra("total",0)));

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
