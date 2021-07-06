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
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

public class user extends AppCompatActivity {

    Button logout,petdata,opinion,Quiz;
    ImageView image;
    TextView name,email;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        mAuth = FirebaseAuth.getInstance();
         FirebaseUser mUser = mAuth.getCurrentUser();
        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);



        logout = findViewById(R.id.googlelogout);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        Quiz = findViewById(R.id.Quiz);
        opinion = findViewById(R.id.opinion);
        petdata = findViewById(R.id.petdata);
        image = findViewById(R.id.image);



        if (signInAccount != null){
            name.setText(signInAccount.getDisplayName());
            email.setText(signInAccount.getEmail());
            Picasso.get().load(signInAccount.getPhotoUrl()).placeholder(R.mipmap.ic_launcher).into(image);
        }



        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),welcome.class);
                startActivity(intent);
                FirebaseAuth.getInstance().signOut();
                finish();
            }
        });

        petdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(user.this,pet.class);
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
                Intent intent = new Intent(user.this,opinion.class);
                startActivity(intent);
                finish();
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnavi);
        bottomNavigationView.setSelectedItemId(R.id.user);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                , homepage.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.search:
                        startActivity(new Intent(getApplicationContext()
                                , search.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.record:
                        startActivity(new Intent(getApplicationContext()
                                , record.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.user:
                        return true;
                }
                return false;
            }
        });
    }

}


