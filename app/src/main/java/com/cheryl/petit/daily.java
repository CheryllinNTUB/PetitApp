package com.cheryl.petit;


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
import android.widget.ImageButton;
import android.widget.Spinner;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class daily extends Fragment {
    private Spinner petname,petbodytype;
    private EditText day_cal,pet_kg;
    private Button calculate;
    ArrayList<String> bodytypeList;
    ArrayAdapter<String>bodytypeAdapter;
    static double bodytype,kg;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference petnameref = db.collection("PetData");
    private List<String> nameList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_daily, container, false);

        petname = v.findViewById(R.id.petname);
        petbodytype = v.findViewById(R.id.petbodytype);
        calculate = v.findViewById(R.id.calculate);
        day_cal = v.findViewById(R.id.day_cal);
        pet_kg = v.findViewById(R.id.pet_kg);



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, nameList);
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








        bodytypeList = new ArrayList<>();
        bodytypeList.add("請選擇寵物類型");
        bodytypeList.add("4個月以下的幼犬");
        bodytypeList.add("4~12月的幼犬");
        bodytypeList.add("未結紮的成犬");
        bodytypeList.add("已結紮的成犬");
        bodytypeList.add("肥胖傾向的成犬");
        bodytypeList.add("減重中的成犬");
        bodytypeList.add("懷孕6周內的母犬");
        bodytypeList.add("懷孕7~9周的母犬");
        bodytypeList.add("哺乳中的母犬");
        bodytypeList.add("輕型工作量的工作犬");
        bodytypeList.add("中型工作量的工作犬");
        bodytypeList.add("重型工作量的工作犬");
        bodytypeList.add("發育中的幼貓");
        bodytypeList.add("未結紮的成貓");
        bodytypeList.add("已結紮的成貓");
        bodytypeList.add("肥胖傾向的成貓");
        bodytypeList.add("減重中的成貓");
        bodytypeList.add("懷孕中的母貓");
        bodytypeList.add("哺乳中的母貓");

        bodytypeAdapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,bodytypeList);
        petbodytype.setAdapter(bodytypeAdapter);


        petbodytype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (adapterView.getItemAtPosition(i).equals("4個月以下的幼犬")) {

                    calculate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            bodytype = 3;
                            kg = Double.parseDouble(pet_kg.getText().toString());
                            Double caltotal = (30*kg + 70)*bodytype;
                            String total = Double.toString(caltotal);
                            day_cal.setText(total);
                        }
                    });
                }

                if (adapterView.getItemAtPosition(i).equals("4~12月的幼犬")) {

                    calculate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            bodytype = 2;
                            kg = Double.parseDouble(pet_kg.getText().toString());
                            Double caltotal = (30*kg + 70)*bodytype;
                            String total = Double.toString(caltotal);
                            day_cal.setText(total);
                        }
                    });
                }

                if (adapterView.getItemAtPosition(i).equals("未結紮的成犬")) {

                    calculate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            bodytype = 1.8;
                            kg = Double.parseDouble(pet_kg.getText().toString());
                            Double caltotal = (30*kg + 70)*bodytype;
                            String total = Double.toString(caltotal);
                            day_cal.setText(total);
                        }
                    });
                }

                if (adapterView.getItemAtPosition(i).equals("已結紮的成犬")) {

                    calculate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            bodytype = 1.6;
                            kg = Double.parseDouble(pet_kg.getText().toString());
                            Double caltotal = (30*kg + 70)*bodytype;
                            String total = Double.toString(caltotal);
                            day_cal.setText(total);
                        }
                    });
                }

                if (adapterView.getItemAtPosition(i).equals("肥胖傾向的成犬")) {

                    calculate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            bodytype = 1.4;
                            kg = Double.parseDouble(pet_kg.getText().toString());
                            Double caltotal = (30 * kg + 70) * bodytype;
                            String total = Double.toString(caltotal);
                            day_cal.setText(total);
                        }
                    });
                }

                if (adapterView.getItemAtPosition(i).equals("減重中的成犬")) {

                    calculate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            bodytype = 1.2;
                            kg = Double.parseDouble(pet_kg.getText().toString());
                            Double caltotal = (30*kg + 70)*bodytype;
                            String total = Double.toString(caltotal);
                            day_cal.setText(total);
                        }
                    });
                }

                if (adapterView.getItemAtPosition(i).equals("懷孕6周內的母犬")) {

                    calculate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            bodytype = 1.8;
                            kg = Double.parseDouble(pet_kg.getText().toString());
                            Double caltotal = (30*kg + 70)*bodytype;
                            String total = Double.toString(caltotal);
                            day_cal.setText(total);
                        }
                    });
                }

                if (adapterView.getItemAtPosition(i).equals("懷孕7~9周的母犬")) {

                    calculate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            bodytype = 3;
                            kg = Double.parseDouble(pet_kg.getText().toString());
                            Double caltotal = (30*kg + 70)*bodytype;
                            String total = Double.toString(caltotal);
                            day_cal.setText(total);
                        }
                    });
                }

                if (adapterView.getItemAtPosition(i).equals("哺乳中的母犬")) {

                    calculate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            bodytype = 4;
                            kg = Double.parseDouble(pet_kg.getText().toString());
                            Double caltotal = (30*kg + 70)*bodytype;
                            String total = Double.toString(caltotal);
                            day_cal.setText(total);
                        }
                    });
                }

                if (adapterView.getItemAtPosition(i).equals("輕型工作量的工作犬")) {

                    calculate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            bodytype = 2;
                            kg = Double.parseDouble(pet_kg.getText().toString());
                            Double caltotal = (30*kg + 70)*bodytype;
                            String total = Double.toString(caltotal);
                            day_cal.setText(total);
                        }
                    });
                }

                if (adapterView.getItemAtPosition(i).equals("中型工作量的工作犬")) {

                    calculate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            bodytype = 3;
                            kg = Double.parseDouble(pet_kg.getText().toString());
                            Double caltotal = (30*kg + 70)*bodytype;
                            String total = Double.toString(caltotal);
                            day_cal.setText(total);
                        }
                    });
                }

                if (adapterView.getItemAtPosition(i).equals("重型工作量的工作犬")) {

                    calculate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            bodytype = 6;
                            kg = Double.parseDouble(pet_kg.getText().toString());
                            Double caltotal = (30*kg + 70)*bodytype;
                            String total = Double.toString(caltotal);
                            day_cal.setText(total);
                        }
                    });
                }

                if (adapterView.getItemAtPosition(i).equals("發育中的幼貓")) {

                    calculate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            bodytype = 2.5;
                            kg = Double.parseDouble(pet_kg.getText().toString());
                            Double caltotal = (30*kg + 70)*bodytype;
                            String total = Double.toString(caltotal);
                            day_cal.setText(total);
                        }
                    });
                }

                if (adapterView.getItemAtPosition(i).equals("未結紮的成貓")) {

                    calculate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            bodytype = 1.4;
                            kg = Double.parseDouble(pet_kg.getText().toString());
                            Double caltotal = (30*kg + 70)*bodytype;
                            String total = Double.toString(caltotal);
                            day_cal.setText(total);
                        }
                    });
                }

                if (adapterView.getItemAtPosition(i).equals("已結紮的成貓")) {

                    calculate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            bodytype = 1.2;
                            kg = Double.parseDouble(pet_kg.getText().toString());
                            Double caltotal = (30*kg + 70)*bodytype;
                            String total = Double.toString(caltotal);
                            day_cal.setText(total);
                        }
                    });
                }

                if (adapterView.getItemAtPosition(i).equals("肥胖傾向的成貓")) {

                    calculate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            bodytype = 1;
                            kg = Double.parseDouble(pet_kg.getText().toString());
                            Double caltotal = (30*kg + 70)*bodytype;
                            String total = Double.toString(caltotal);
                            day_cal.setText(total);
                        }
                    });
                }

                if (adapterView.getItemAtPosition(i).equals("減重中的成貓")) {

                    calculate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            bodytype = 0.8;
                            kg = Double.parseDouble(pet_kg.getText().toString());
                            Double caltotal = (30*kg + 70)*bodytype;
                            String total = Double.toString(caltotal);
                            day_cal.setText(total);
                        }
                    });
                }

                if (adapterView.getItemAtPosition(i).equals("懷孕中的母貓")) {

                    calculate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            bodytype = 1.6;
                            kg = Double.parseDouble(pet_kg.getText().toString());
                            Double caltotal = (30*kg + 70)*bodytype;
                            String total = Double.toString(caltotal);
                            day_cal.setText(total);
                        }
                    });
                }

                if (adapterView.getItemAtPosition(i).equals("哺乳中的母貓")) {

                    calculate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            bodytype = 4;
                            kg = Double.parseDouble(pet_kg.getText().toString());
                            Double caltotal = (30*kg + 70)*bodytype;
                            String total = Double.toString(caltotal);
                            day_cal.setText(total);
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return v;
    }

}
