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

public class Hotelpage extends AppCompatActivity {
    private FirebaseFirestore firebaseFirestore;
    private ImageButton back;
    private ImageView hotel_img;
    private TextView hotel_name,hotel_details,hotel_address;
    private Button findon_net,hotel_map,add_love;
    private ImageButton fb,email,line;
    CollectionReference hotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotelpage);
        hotel_img = findViewById(R.id.hotel_img);
        hotel_name = findViewById(R.id.hotel_name);
        hotel_details = findViewById(R.id.hotel_details);
        findon_net = findViewById(R.id.findon_net);
        hotel_map = findViewById(R.id.hotel_map);
        add_love = findViewById(R.id.add_love);
        fb = findViewById(R.id.fb);
        line = findViewById(R.id.line);
        email = findViewById(R.id.email);


        Intent intent = getIntent();
        Hotelmodel hotelmodel = (Hotelmodel)intent.getBundleExtra("bundle").getSerializable("key");
        Log.d("Hotel",hotelmodel.getHotelname());


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Hotelpage.this, hotel.class);
                startActivity(intent);
            }
        });
    }
}
