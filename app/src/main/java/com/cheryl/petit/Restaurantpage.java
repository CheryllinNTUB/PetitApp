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

public class Restaurantpage extends AppCompatActivity {
    private ImageView rest_img;
    private TextView rest_name,restabout,rest_city,rest_reigon,phonecall,fb;
   //private CollectionReference locals = firebaseFirestore.collection("Restaurants");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurantpage);
        rest_img = findViewById(R.id.restaurant_img);
        rest_name = findViewById(R.id.restaurant_name);
        rest_city = findViewById(R.id.restaurant_city);
        rest_reigon = findViewById(R.id.restaurant_reigon);
        restabout = findViewById(R.id.restaurantabout);
        phonecall = findViewById(R.id.phonecall);
        fb = findViewById(R.id.fb);


        Intent intent = getIntent();
        Restaurantmodel restaurantmodel = (Restaurantmodel)intent.getBundleExtra("bundle").getSerializable("key");
        rest_name.setText(restaurantmodel.getRestname());
        rest_city.setText(restaurantmodel.getRestcity());
        rest_reigon.setText(restaurantmodel.getRestreigon());
        restabout.setText(restaurantmodel.getRestabout());
        phonecall.setText(restaurantmodel.getResttel());
        fb.setText(restaurantmodel.getRestfacebook());
        Picasso.get().load(restaurantmodel.getRestimg()).into(rest_img);

    }

    }

