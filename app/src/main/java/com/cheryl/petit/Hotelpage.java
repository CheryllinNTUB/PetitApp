package com.cheryl.petit;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

public class Hotelpage extends AppCompatActivity {
    private ImageView hotel_img;
    private TextView hotel_name,hotelabout,hotel_city,hotel_reigon,phonecall,fb,email,web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotelpage);
        hotel_img = findViewById(R.id.hotel_img);
        hotel_name = findViewById(R.id.hotel_name);
        hotelabout = findViewById(R.id.hotelabout);
        hotel_city = findViewById(R.id.hotel_city);
        hotel_reigon = findViewById(R.id.hotel_reigon);
        phonecall = findViewById(R.id.phonecall);
        fb = findViewById(R.id.fb);
        email = findViewById(R.id.email);
        web = findViewById(R.id.web);


        Intent intent = getIntent();
        Hotelmodel hotelmodel = (Hotelmodel)intent.getBundleExtra("bundle").getSerializable("key");
        hotel_name.setText(hotelmodel.getHotelname());
        hotel_city.setText(hotelmodel.getHotelcity());
        hotel_reigon.setText(hotelmodel.getHotelreigon());
        hotelabout.setText(hotelmodel.getHotelabout());
        phonecall.setText(hotelmodel.getHotelphone());
        fb.setText(hotelmodel.getHotelfacebook());
        email.setText(hotelmodel.getHotelemail());
        web.setText(hotelmodel.getHotelwebsite());
        Picasso.get().load(hotelmodel.getHotelimg()).into(hotel_img);




    }
}
