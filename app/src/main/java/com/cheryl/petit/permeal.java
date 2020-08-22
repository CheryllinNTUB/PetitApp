package com.cheryl.petit;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class permeal extends Fragment {

    private Button calculate;
    private EditText food_weight,food_totalcal,eat_weight,eat_totalcal,foodname;
    private Button look,finish;
    private Spinner petname,foodtype;
    static double foodweight,foodtotalcal,eatweight;
    ArrayList<String> foodList;
    ArrayAdapter<String>foodAdapter;
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private String uid = user.getUid();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_permeal, container, false);

       petname = v.findViewById(R.id.petname);
       foodtype = v.findViewById(R.id.foodtype);
       food_weight = v.findViewById(R.id.foodweight);
       food_totalcal = v.findViewById(R.id.foodtotalcal);
       foodname = v.findViewById(R.id.foodname);
       eat_weight = v.findViewById(R.id.eatweight);
       eat_totalcal = v.findViewById(R.id.eattotalcal);
       calculate = v.findViewById(R.id.calculate);
       look = v.findViewById(R.id.look);
       finish = v.findViewById(R.id.finish);



        foodList = new ArrayList<>();
        foodList.add("請選擇食品類型");
        foodList.add("罐裝寵物食品");
        foodList.add("乾燥型寵物食品");
        foodList.add("軟濕型寵物食品");
        foodList.add("自製鮮食/鮮食包");
        foodList.add("零食點心");
        foodList.add("健康食品");

        foodAdapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,foodList);
        foodtype.setAdapter(foodAdapter);

        foodtype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               if (adapterView.getItemAtPosition(i).equals("自製鮮食/鮮食包"))
               {
                   look.setVisibility(View.VISIBLE);
               }
               else
               {
                   look.setVisibility(View.INVISIBLE);
               }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //計算攝取熱量
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                foodweight = Double.parseDouble(food_weight.getText().toString());
                foodtotalcal = Double.parseDouble(food_totalcal.getText().toString());
                eatweight = Double.parseDouble(eat_weight.getText().toString());
                Double eattotal = (foodtotalcal / foodweight) * eatweight;
                String total = Double.toString(eattotal);
                eat_totalcal.setText(total);

                }
        });

        look.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent foodIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://health.udn.com/health/calorie"));
                startActivity(foodIntent);
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
                db.collection("Petpermeal").document().set(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getContext(),"已更新卡路里資料",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        return v;
    }
}
