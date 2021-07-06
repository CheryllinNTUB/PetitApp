package com.cheryl.petit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.telephony.RadioAccessSpecifier;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class doc extends AppCompatActivity {
    private ImageButton back;
    private TextView backdate;
    private EditText datepick,whysick,hospital,note,backdocday;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    private DatePickerDialog.OnDateSetListener dateSetListener2;
    private RadioButton yes,no;
    private Spinner petname;
    private Button finish;
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private String uid = user.getUid();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference petnameref = db.collection("PetData");
    private List<String> nameList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc);
        back = findViewById(R.id.back);
        datepick = findViewById(R.id.datepick);
        whysick = findViewById(R.id.whysick);
        hospital = findViewById(R.id.hospital);
        note = findViewById(R.id.note);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        backdocday = findViewById(R.id.backdocday);
        backdate = findViewById(R.id.backdate);
        petname = findViewById(R.id.petname);
        finish = findViewById(R.id.finish);


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



        if (user == null) {
            // No session user
            return;
        }


//是否需要回診按鈕顯示
        yes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    backdocday.setVisibility(View.VISIBLE);
                    backdate.setVisibility(View.VISIBLE);
                    no.setChecked(false);
                }
            }
        });
        no.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    backdocday.setVisibility(View.INVISIBLE);
                    backdate.setVisibility(View.INVISIBLE);
                    yes.setChecked(false);
                }
            }
        });



        datepick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(
                        doc.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        dateSetListener, year, month, day
                );

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        backdocday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(
                        doc.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        dateSetListener2, year, month, day
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

        dateSetListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                month = month + 1;

                String thedate2 = year + "/" + month + "/" + day;

                backdocday.setText(thedate2);
            }
        };


        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String,String> map = new HashMap<>();
                map.put("userID",uid);
                map.put("docday",datepick.getText().toString());
                map.put("whysick",whysick.getText().toString());
                map.put("hospital",hospital.getText().toString());
                map.put("sicknote",note.getText().toString());
                String n1 = yes.getText().toString();
                String n2 = no.getText().toString();
                if (yes.isChecked()){
                    map.put("backtodoc",yes.getText().toString());
                    map.put("backtodocday",backdocday.getText().toString());
                }
                else{
                    map.put("backtodoc",no.getText().toString());
                }
                map.put("petname",petname.getSelectedItem().toString());

                db.collection("DocData").document().set(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"已更新看診資料",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });






                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(doc.this, adddoc.class);
                        startActivity(intent);
                        finish();
                    }
                });

            }

}
