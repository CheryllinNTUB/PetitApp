package com.cheryl.petit;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;


public class phone_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_login);

        final EditText phoneEn = findViewById(R.id.phoneEn);
        final Button next = findViewById(R.id.next);

        final ProgressBar progressBar = findViewById(R.id.progressbar);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (phoneEn.getText().toString().trim().isEmpty()){
                    Toast.makeText(phone_login.this,"請輸入電話號碼!!",Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                next.setVisibility(View.INVISIBLE);

                PhoneAuthProvider.getInstance().verifyPhoneNumber("+886" + phoneEn.getText().toString(),60, TimeUnit.SECONDS,phone_login.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
                    @Override
                    public void onVerificationCompleted(@NonNull @NotNull PhoneAuthCredential phoneAuthCredential) {
                        progressBar.setVisibility(View.GONE);
                        next.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onVerificationFailed(@NonNull @NotNull FirebaseException e) {
                        progressBar.setVisibility(View.GONE);
                        next.setVisibility(View.VISIBLE);
                        Toast.makeText(phone_login.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCodeSent(@NonNull @NotNull String verificationId, @NonNull @NotNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        progressBar.setVisibility(View.GONE);
                        next.setVisibility(View.VISIBLE);
                        Intent intent = new Intent(getApplicationContext(),verifycode.class);
                        intent.putExtra("mobile",phoneEn.getText().toString());
                        intent.putExtra("verificationId",verificationId);
                        startActivity(intent);
                    }
                });

            }
        });


    }




}
