package com.cheryl.petit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.squareup.picasso.Picasso;


public class Parkpage extends AppCompatActivity {
    private ImageView park_img;
    private TextView park_name,park_details,park_city,park_reigon;
    private ImageButton back;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference parkref = db.collection("Park");
    private Button park_map,add_love;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parkpage);
        back = findViewById(R.id.back);
        park_img = findViewById(R.id.park_img);
        park_name = findViewById(R.id.parkname);
        park_city = findViewById(R.id.park_city);
        park_reigon = findViewById(R.id.park_reigon);
        park_details = findViewById(R.id.park_details);
        park_map= findViewById(R.id.park_map);
        add_love = findViewById(R.id.add_love);

        Intent intent = getIntent();
        Parkmodel parkmodel = (Parkmodel)intent.getBundleExtra("bundle").getSerializable("key");
        Log.d("Park",parkmodel.getParkname());


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Parkpage.this,park.class);
                startActivity(intent);
            }
        });
    }

    CollectionReference =





   /* @Override
    public void onStart(){
        super.onStart();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String currentid = user.getUid();
        DocumentReference reference;
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        reference = firestore.collection("Park").document(currentid);

        reference.get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                       if (task.getResult().exists()){

                        String parkname = task.getResult().getString("Parkname");
                        String parkcity = task.getResult().getString("Parkcity");
                        String parkreigon = task.getResult().getString("Parkreigon");
                        String parkdetails = task.getResult().getString("Park_details");
                        String parkimg = task.getResult().getString("Parkimg");

                        Picasso.get().load(parkimg).into(park_img);
                        park_name.setText(parkname);
                        park_city.setText(parkcity);
                        park_reigon.setText(parkreigon);
                        park_details.setText(parkdetails);

                       }
                    }
                });


    }*/
}
