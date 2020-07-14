package com.cheryl.petit;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.math.BigDecimal;
import java.text.NumberFormat;


public class permeal extends Fragment {

    private Button calculate;
    private EditText food_weight,food_totalcal,eat_weight,eat_totalcal;
    private Spinner foodtype;
    static double foodweight,foodtotalcal,eatweight;
    static String eattotalcal;

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


        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                v.getContext(), R.layout.custom_spinner,
                getResources().getStringArray(R.array.list8)
        );

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
