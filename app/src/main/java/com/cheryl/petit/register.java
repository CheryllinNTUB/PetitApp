package com.cheryl.petit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class register extends AppCompatActivity {
    private TextInputLayout nickname,account,password,passwordcheck;
    private Button finish,gotologin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nickname = (TextInputLayout) findViewById(R.id.nickname);
        account = (TextInputLayout) findViewById(R.id.account);
        password = (TextInputLayout) findViewById(R.id.password);
        passwordcheck = (TextInputLayout) findViewById(R.id.passwordcheck);
        finish = (Button) findViewById(R.id.finish);
        gotologin = (Button) findViewById(R.id.gotologin);

        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(register.this, login.class);
                startActivity(intent);
            }
        });


    }

    }

