package com.cheryl.petit;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class adddoc extends AppCompatActivity {
    private ImageButton back,add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddoc);

        back =  findViewById(R.id.back);
        add =findViewById(R.id.add);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(adddoc.this,homepage.class);
                intent.putExtra("adddoc",11);
                startActivity(intent);
                finish();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(adddoc.this, doc.class);
                startActivity(intent);
            }
        });
    }
}
