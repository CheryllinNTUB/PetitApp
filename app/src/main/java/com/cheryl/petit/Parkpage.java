package com.cheryl.petit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.GeoPoint;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firestore.v1.Document;
import com.squareup.picasso.Picasso;

import java.util.List;


public class Parkpage extends AppCompatActivity {
    private ImageView park_img;
    private TextView park_name1,park_name2,parkabout,park_city,park_reigon;
    private ImageButton back;
    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parkpage);
        park_img = findViewById(R.id.park_img);
        park_name1 = findViewById(R.id.park_name1);
        park_name2 = findViewById(R.id.park_name2);
        park_city = findViewById(R.id.park_city);
        park_reigon = findViewById(R.id.park_reigon);
        parkabout = findViewById(R.id.parkabout);
        back = findViewById(R.id.back);

        Intent intent = getIntent();
        Parkmodel parkmodel = (Parkmodel) intent.getBundleExtra("bundle").getSerializable("key");
        park_name1.setText(parkmodel.getParkname());
        park_name2.setText(parkmodel.getParkname());
        park_city.setText(parkmodel.getParkcity());
        park_reigon.setText(parkmodel.getParkreigon());
        parkabout.setText(parkmodel.getParkabout());
        Picasso.get().load(parkmodel.getParkimg()).into(park_img);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Parkpage.this, park.class);
                startActivity(intent);
                finish();
            }
        });

    }

}
