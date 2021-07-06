package com.cheryl.petit;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import java.text.DecimalFormat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class permeal extends AppCompatActivity {

    private Button calculate,finish;
    private ImageButton back;
    private EditText food_weight,food_totalcal,eat_weight,eat_totalcal,foodname,datepick,dailycal,re;
    private Spinner petname,foodtype,meal;
    private double foodw,foodto,eatw,a1,a2;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    ArrayList<String> foodList;
    ArrayAdapter<String>foodAdapter;
    ArrayList<String>mealkind;
    ArrayAdapter<String>mealAdapter;
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private String uid = user.getUid();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference petnameref = db.collection("PetData");
    private CollectionReference weightref = db.collection("PetweightRecord");
    private List<String> nameList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permeal);

       petname = findViewById(R.id.petname);
       foodtype = findViewById(R.id.foodtype);
       meal = findViewById(R.id.meal);
       food_weight = findViewById(R.id.foodweight);
       food_totalcal = findViewById(R.id.foodtotalcal);
       foodname = findViewById(R.id.foodname);
       eat_weight = findViewById(R.id.eatweight);
       eat_totalcal = findViewById(R.id.eattotalcal);
       calculate = findViewById(R.id.calculate);
       finish = findViewById(R.id.finish);
       datepick = findViewById(R.id.datepick);
       back = findViewById(R.id.back);
       dailycal = findViewById(R.id.dailycal);
       re = findViewById(R.id.re);



        datepick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(
                        permeal.this,
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

                datepick.setText(thedate);
            }
        };





        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, nameList);
        petname.setAdapter(adapter);
        petnameref.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot documentSnapshot : task.getResult()){
                        String mpetname = documentSnapshot.getString("petname");
                        nameList.add(mpetname);
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        });


        weightref.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot documentSnapshot : task.getResult()){
                        String mrecal = documentSnapshot.getString("day_cal");
                        dailycal.setText(mrecal);

                    }
                    adapter.notifyDataSetChanged();

                }
            }
        });



        foodList = new ArrayList<>();
        foodList.add("請選擇食品類型");
        foodList.add("罐裝寵物食品");
        foodList.add("乾燥型寵物食品");
        foodList.add("軟濕型寵物食品");
        foodList.add("自製鮮食/鮮食包");
        foodList.add("零食點心");
        foodList.add("健康食品");

        mealkind = new ArrayList<>();
        mealkind.add("請選擇餐別");
        mealkind.add("早餐");
        mealkind.add("午餐");
        mealkind.add("晚餐");
        mealkind.add("點心");



        foodAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,foodList);
        foodtype.setAdapter(foodAdapter);

        mealAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,mealkind);
        meal.setAdapter(mealAdapter);






        //計算攝取熱量
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                foodw = Double.parseDouble(food_weight.getText().toString());
                foodto = Double.parseDouble(food_totalcal.getText().toString());
                eatw = Double.parseDouble(eat_weight.getText().toString());
                double eattotal = (foodto / foodw) * eatw;
                String total = Double.toString(eattotal);
                eat_totalcal.setText(total);

                a1 = Double.parseDouble(dailycal.getText().toString());
                a2 = Double.parseDouble(eat_totalcal.getText().toString());
                double recal = (a1 - a2);
                String r = Double.toString(recal);
                re.setText(r);


                }
        });





        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String,String> map = new HashMap<>();
                map.put("userID",uid);
                map.put("petname",petname.getSelectedItem().toString());
                map.put("foodtype",foodtype.getSelectedItem().toString());
                map.put("foodname",foodname.getText().toString());
                map.put("eattotalcal",eat_totalcal.getText().toString());
                map.put("mealkind",meal.getSelectedItem().toString());
                map.put("dated",datepick.getText().toString());
                map.put("recal",re.getText().toString());


                db.collection("Petpermeal").document().set(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"已新增卡路里資料",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(permeal.this, addcal.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
