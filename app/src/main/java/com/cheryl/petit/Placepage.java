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

public class Placepage extends AppCompatActivity {

    private ImageView place_img;
    private TextView place_name,place_city,place_reigon,phonecall,fb,web,email,placeabout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placepage);
        place_img = findViewById(R.id.place_img);
        place_name = findViewById(R.id.place_name);
        place_city = findViewById(R.id.placecity);
        place_reigon = findViewById(R.id.placereigon);
        phonecall = findViewById(R.id.phonecall);
        fb = findViewById(R.id.fb);
        web = findViewById(R.id.web);
        email = findViewById(R.id.email);
        placeabout = findViewById(R.id.placeabout);


        Intent intent = getIntent();
        Placemodel placemodel = (Placemodel)intent.getBundleExtra("bundle").getSerializable("key");
        place_name.setText(placemodel.getPlacename());
        place_city.setText(placemodel.getPlacecity());
        place_reigon.setText(placemodel.getPlacereigon());
        placeabout.setText(placemodel.getPlaceabout());
        phonecall.setText(placemodel.getPlacephone());
        fb.setText(placemodel.getPlacefacebook());
        web.setText(placemodel.getPlacewebsite());
        email.setText(placemodel.getPlaceemail());
        Picasso.get().load(placemodel.getPlaceimg()).into(place_img);


    }
}
