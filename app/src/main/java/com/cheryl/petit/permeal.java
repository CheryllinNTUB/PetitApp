package com.cheryl.petit;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;


public class permeal extends Fragment {

    private Button calculate;
    private EditText food_weight,food_totalcal,eat_weight,eat_totalcal;
    private Button look;
    private Spinner foodtype;
    static double foodweight,foodtotalcal,eatweight;
    ArrayList<String> foodList;
    ArrayAdapter<String>foodAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_permeal, container, false);

       foodtype = v.findViewById(R.id.foodtype);
       food_weight = v.findViewById(R.id.food_weight);
       food_totalcal = v.findViewById(R.id.food_totalcal);
       eat_weight = v.findViewById(R.id.eat_weight);
       eat_totalcal = v.findViewById(R.id.eat_totalcal);
       calculate = v.findViewById(R.id.calculate);
       look = v.findViewById(R.id.look);

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
        return v;
    }
}
