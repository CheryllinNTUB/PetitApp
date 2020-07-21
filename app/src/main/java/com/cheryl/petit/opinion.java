package com.cheryl.petit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class opinion extends AppCompatActivity {
    private EditText email,subject,message;
    private Button send;
    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opinion);

        email = findViewById(R.id.email);
        subject = findViewById(R.id.subject);
        message = findViewById(R.id.message);
        send = findViewById(R.id.send);
        back = findViewById(R.id.back);

        //返回鍵
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(opinion.this, homepage.class);
                startActivity(intent);
            }
        });

        //寄出email
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent it = new Intent(Intent.ACTION_SEND);
               it.putExtra(Intent.EXTRA_EMAIL,new String[]{email.getText().toString()});
               it.putExtra(Intent.EXTRA_SUBJECT,subject.getText().toString());
               it.putExtra(Intent.EXTRA_TEXT,message.getText());
               it.setType("message/rfc822");
               startActivity(Intent.createChooser(it,"Choose Mail App"));
            }
        });
    }
}
