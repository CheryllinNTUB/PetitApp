package com.cheryl.petit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;


public class welcome extends AppCompatActivity {

    private GoogleSignInClient mGoogleSignInClient;
    private Button gologin,phonelogin;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        gologin = findViewById(R.id.gologin);
        phonelogin = findViewById(R.id.phonelogin);



        phonelogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(welcome.this, com.cheryl.petit.phone_login.class);
                startActivity(intent);
                finish();
            }
        });


        //按鈕動畫
        gologin.setAlpha(0f);
        gologin.setTranslationY(30);
        gologin.animate().alpha(1f).translationYBy(-50).setStartDelay(1200).setDuration(1500);
        phonelogin.setAlpha(0f);
        phonelogin.setTranslationY(30);
        phonelogin.animate().alpha(1f).translationYBy(-50).setStartDelay(1200).setDuration(1500);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(welcome.this
        ,gso);

        gologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(intent,100);
            }
        });

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = mAuth.getCurrentUser();
        if (firebaseUser != null){
            startActivity(new Intent(welcome.this,user.class)
            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode == 100) {
            Task<GoogleSignInAccount> task = GoogleSignIn
                    .getSignedInAccountFromIntent(data);
            if (task.isSuccessful()){
                String s = "登入成功";
                displayToast(s);
                try {
                    GoogleSignInAccount googleSignInAccount = task
                            .getResult(ApiException.class);
                    if (googleSignInAccount != null){
                        AuthCredential authCredential = GoogleAuthProvider
                                .getCredential(googleSignInAccount.getIdToken()
                                        ,null);

                        mAuth.signInWithCredential(authCredential)
                                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                                        if (task.isSuccessful()){
                                            startActivity(new Intent(welcome.this
                                                    ,user.class)
                                                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                                            displayToast("登入成功");
                                        }else{
                                            displayToast("登入失敗" + task.getException().getMessage());
                                        }
                                    }
                                });
                    }
                } catch (ApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void displayToast(String s) {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();

    }

}
