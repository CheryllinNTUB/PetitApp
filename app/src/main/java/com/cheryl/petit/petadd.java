package com.cheryl.petit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import de.hdodenhof.circleimageview.CircleImageView;

public class petadd extends AppCompatActivity {
    private ImageButton back;
    private CircleImageView head;
    private RadioButton dog,cat,male,female;
    private Button finish;
    private static final int GALLER_ACTION_PICK_CODE = 10;
    private Uri imageuri;
    private EditText name,variety,birthday;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DatePickerDialog.OnDateSetListener dateSetListener;
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private String uid = user.getUid();
    private FirebaseStorage storage;
    private StorageReference storageReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petadd);

        back =findViewById(R.id.back);
        name = findViewById(R.id.pet_name);
        variety = findViewById(R.id.petvariety);
        birthday = findViewById(R.id.birthday);
        dog = findViewById(R.id.dog);
        cat = findViewById(R.id.cat);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        head = findViewById(R.id.head);
        finish = findViewById(R.id.addfinish);
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();


        if (user == null) {
            // No session user
            return;
        }




        //寫入資料到資料庫
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String,String> map = new HashMap<>();
                uploadImage();
                map.put("uid",uid);
                map.put("pethead",imageuri.toString());
                map.put("petname",name.getText().toString());
                String r1 = dog.getText().toString();
                String r2 = cat.getText().toString();
                if (dog.isChecked()){
                    map.put("petkind",dog.getText().toString());
                }
                else{
                    map.put("petkind",cat.getText().toString());
                }
                map.put("petvariety",variety.getText().toString());
                String s1 = male.getText().toString();
                String s2 = female.getText().toString();
                if (male.isChecked()){
                    map.put("petsex",male.getText().toString());
                }
                else{
                    map.put("petsex",female.getText().toString());
                }
                map.put("petbirthday",birthday.getText().toString());

                db.collection("PetData").document().set(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"已更新寵物資料",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(petadd.this, pet.class);
                startActivity(intent);
            }
        });

        birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(
                        petadd.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        dateSetListener, year, month, day
                );

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();


            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                month = month + 1;

                String thedate = year + "/" + month + "/" + day;

                birthday.setText(thedate);
            }
        };
        //更換大頭照
        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runTimePermisson();
            }
        });
    }

    private void uploadImage() {

        if (imageuri != null)
        {
            ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("上傳中...");
            progressDialog.show();

            StorageReference ref = storageReference.child("image/"+ UUID.randomUUID().toString());
            ref.putFile(imageuri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
                            Toast.makeText(petadd.this,"上傳成功",Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(petadd.this,"Failed"+e.getMessage() ,Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                        }
                    });
        }
    }


    private void runTimePermisson(){

        Dexter.withContext(this).
                withPermission(
                        Manifest.permission.READ_EXTERNAL_STORAGE
                ).withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                galleryIntent();
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken token) {
                token.continuePermissionRequest();
            }
        }).check();

    }

    private void galleryIntent() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,GALLER_ACTION_PICK_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode == GALLER_ACTION_PICK_CODE && resultCode == RESULT_OK && data != null){


                imageuri = data.getData();

                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),imageuri);
                    head.setImageBitmap(bitmap);
                }catch (IOException e){
                    e.printStackTrace();
                }

            }
        }
    }


