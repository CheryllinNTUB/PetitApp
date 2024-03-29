package com.cheryl.petit;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.gms.dynamic.IFragmentWrapper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

public class Hospitalpage extends Activity {
    private ImageView hospital_img;
    private TextView hospital_name,hospital_city,hospital_reigon,phonecall,fb,email,web;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitalpage);
        hospital_img = findViewById(R.id.hospital_img);
        hospital_name = findViewById(R.id.hospital_name);
        hospital_city = findViewById(R.id.hospital_city);
        hospital_reigon = findViewById(R.id.hospital_reigon);
        phonecall = findViewById(R.id.phonecall);
        fb = findViewById(R.id.fb);
        email = findViewById(R.id.email);
        web = findViewById(R.id.web);

        Intent intent = getIntent();
        Hospitalmodel hospitalmodel = (Hospitalmodel) intent.getBundleExtra("bundle").getSerializable("key");
        hospital_name.setText(hospitalmodel.getHospitalname());
        hospital_city.setText(hospitalmodel.getHospitalcity());
        hospital_reigon.setText(hospitalmodel.getHospitalreigon());
        phonecall.setText(hospitalmodel.getHospitalphone());
        fb.setText(hospitalmodel.getHospitalfacebook());
        email.setText(hospitalmodel.getHospitalemail());
        web.setText(hospitalmodel.getHospitalwebsite());
        Picasso.get().load(hospitalmodel.getHospitalimg()).into(hospital_img);





    }

}
