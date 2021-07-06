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
    private FirebaseFirestore firebaseFirestore;
    private ImageView hotel_img;
    private TextView hotel_name1,hotel_name2,hotelabout,hotel_city,hotel_reigon,phonecall,fb,email,web;
    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotelpage);
        hotel_img = findViewById(R.id.hotel_img);
        hotel_name1 = findViewById(R.id.hotel_name1);
        hotel_name2 = findViewById(R.id.hotel_name2);
        hotelabout = findViewById(R.id.hotelabout);
        hotel_city = findViewById(R.id.hotel_city);
        hotel_reigon = findViewById(R.id.hotel_reigon);
        phonecall = findViewById(R.id.phonecall);
        fb = findViewById(R.id.fb);
        email = findViewById(R.id.email);
        web = findViewById(R.id.web);
        back = findViewById(R.id.back);

        Intent intent = getIntent();
        Hotelmodel hotelmodel = (Hotelmodel)intent.getBundleExtra("bundle").getSerializable("key");
        hotel_name1.setText(hotelmodel.getHotelname());
        hotel_name2.setText(hotelmodel.getHotelname());
        hotel_city.setText(hotelmodel.getHotelcity());
        hotel_reigon.setText(hotelmodel.getHotelreigon());
        hotelabout.setText(hotelmodel.getHotelabout());
        phonecall.setText(hotelmodel.getHotelphone());
        fb.setText(hotelmodel.getHotelfacebook());
        email.setText(hotelmodel.getHotelemail());
        web.setText(hotelmodel.getHotelwebsite());
        Picasso.get().load(hotelmodel.getHotelimg()).into(hotel_img);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Hotelpage.this, hotel.class);
                startActivity(intent);
                finish();
            }
        });



    }
}
