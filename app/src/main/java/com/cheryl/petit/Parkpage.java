package com.cheryl.petit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Parkpage extends AppCompatActivity {
    private FirebaseFirestore firebaseFirestore;
    private ImageView park_img;
    private TextView park_name,park_details;
    private ImageButton back;
    private Button findon_net,park_map,add_love;
    CollectionReference park;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parkpage);
        back = findViewById(R.id.back);
        park_img = findViewById(R.id.park_img);
        park_name = findViewById(R.id.parkname);
        park_details = findViewById(R.id.park_details);
        findon_net = findViewById(R.id.findon_net);
        park_map= findViewById(R.id.park_map);
        add_love = findViewById(R.id.add_love);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        Parkmodel parkmodel = (Parkmodel) bundle.getSerializable("key");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Parkpage.this,park.class);
                startActivity(intent);
            }
        });

        /*
        DocumentReference documentReference = firebaseFirestore.collection("Park").document();
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                Picasso.get().load(parkmodel.getParkimg()).into(park_img);
                
            }
        });*/
    }
}
