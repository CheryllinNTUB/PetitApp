package com.cheryl.petit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthProvider;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

public class user extends AppCompatActivity {

    Button logout,petdata,opinion,Quiz;
    ImageView image;
    TextView email,number;
    private FirebaseAuth mAuth;
    GoogleSignInClient googleSignInClient;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        mAuth = FirebaseAuth.getInstance();


        logout = findViewById(R.id.googlelogout);
        email = findViewById(R.id.email);
        number = findViewById(R.id.number);
        Quiz = findViewById(R.id.Quiz);
        opinion = findViewById(R.id.opinion);
        petdata = findViewById(R.id.petdata);
        image = findViewById(R.id.image);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        try {
            number.setText(user.getPhoneNumber());
        } catch (Exception e) {
            Toast.makeText(this, "查無此電話號碼", Toast.LENGTH_SHORT).show();
        }


        FirebaseUser firebaseUser = mAuth.getCurrentUser();
        if (firebaseUser != null) {
            email.setText(firebaseUser.getEmail());
            Picasso.get().load(firebaseUser.getPhotoUrl())
                    .placeholder(R.mipmap.ic_launcher).into(image);
        }

        googleSignInClient = GoogleSignIn.getClient(user.this
                , GoogleSignInOptions.DEFAULT_SIGN_IN);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), welcome.class);
                startActivity(intent);
            }
        });

        petdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(user.this, pet.class);
                startActivity(intent);
                finish();
            }
        });

        Quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(user.this, com.cheryl.petit.Quiz.class);
                startActivity(intent);
                finish();
            }
        });

        opinion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(user.this, opinion.class);
                startActivity(intent);
                finish();
            }
        });

        bottomNavigationView = findViewById(R.id.bottomnavi);
        bottomNavigationView.setSelectedItemId(R.id.navi_user);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navi_article:
                        startActivity(new Intent(getApplicationContext()
                                ,homepage.class ));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.navi_search:
                        startActivity(new Intent(getApplicationContext()
                                ,search.class ));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.navi_record:
                        startActivity(new Intent(getApplicationContext()
                                ,record.class ));
                        overridePendingTransition(0,0);
                        return true;


                    case R.id.navi_user:

                        return true;
                }
                return false;
            }
        });


    }
}


