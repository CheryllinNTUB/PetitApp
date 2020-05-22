package com.cheryl.petit;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

public class register extends AppCompatActivity {
    private EditText nickname,account,password,passwordcheck;
    private Button finish,gotologin;
    private ProgressBar loading;
    private static String URL_REGIST ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nickname =  findViewById(R.id.input_nickname);
        account = findViewById(R.id.input_account);
        password =  findViewById(R.id.input_password);
        passwordcheck =  findViewById(R.id.input_checkpass);
        loading =findViewById(R.id.loading);
        finish =findViewById(R.id.finish);
        gotologin = findViewById(R.id.gotologin);

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(register.this, homepage.class);
                startActivity(intent);
            }
        });


        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(register.this, login.class);
                startActivity(intent);
            }
        });


    }



    private void  Regist(){
        loading.setVisibility(View.VISIBLE);
        finish.setVisibility(View.GONE);

        final String nickname = this.nickname.getText().toString().trim();
        final String account = this.account.getText().toString().trim();
        final String password = this.password.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                })

        {
            @Override
            protected Map<String,String>getParams() throws AuthFailureError{
                return  super.getParams();
            }
        };


    }

    }

