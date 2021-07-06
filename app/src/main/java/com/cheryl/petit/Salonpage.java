package com.cheryl.petit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

public class Salonpage extends AppCompatActivity {

    private ImageView salon_img;
    private TextView salon_name1,salon_name2,salonabout,salon_city,salon_reigon,phonecall,fb,web;
    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salonpage);
        salon_img = findViewById(R.id.salon_img);
        salon_name1 = findViewById(R.id.salon_name1);
        salon_name2 = findViewById(R.id.salon_name2);
        salonabout = findViewById(R.id.salonabout);
        salon_city = findViewById(R.id.salon_city);
        salon_reigon = findViewById(R.id.salon_reigon);
        phonecall = findViewById(R.id.phonecall);
        back = findViewById(R.id.back);
        fb = findViewById(R.id.fb);
        web = findViewById(R.id.web);


        Intent intent = getIntent();
        Salonmodel salonmodel = (Salonmodel)intent.getBundleExtra("bundle").getSerializable("key");
        salon_name1.setText(salonmodel.getSalnname());
        salon_name2.setText(salonmodel.getSalnname());
        salon_city.setText(salonmodel.getSalncity());
        salon_reigon.setText(salonmodel.getSalnreigon());
        phonecall.setText(salonmodel.getSalntel());
        fb.setText(salonmodel.getSalnfacebook());
        web.setText(salonmodel.getSalnOffiweb());
        salonabout.setText(salonmodel.getSalnabout());
        Picasso.get().load(salonmodel.getSalnimg()).into(salon_img);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Salonpage.this, salon.class);
                startActivity(intent);
                finish();
            }
        });
    }



}
