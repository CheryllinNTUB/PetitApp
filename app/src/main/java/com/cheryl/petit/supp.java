package com.cheryl.petit;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static android.widget.Toast.LENGTH_SHORT;

public class supp extends AppCompatActivity {
    private ImageButton back;
    private Button finish;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    private EditText brand,name,date;
    private Spinner supptype,supptime;
    private Calendar calendar ;
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private String uid = user.getUid();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    ArrayList<String> typeList;
    ArrayAdapter<String>typeAdapter;
    ArrayList<String> timeList;
    ArrayAdapter<String>timeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supp);
        finish =findViewById(R.id.finish);
        back = findViewById(R.id.back);
        brand = findViewById(R.id.suppbrand);
        name = findViewById(R.id.suppname);
        date = findViewById(R.id.date);
        supptime = findViewById(R.id.supptime);
        supptype = findViewById(R.id.supptype);
        createNotificationChannel();


        typeList = new ArrayList<>();
        typeList .add("請選擇種類");
        typeList .add("保健食品/用品");
        typeList .add("飼料/罐頭");
        typeList .add("籠具/圍欄");
        typeList .add("清潔用品");
        typeList .add("服裝");
        typeList .add("外出用品");
        typeList .add("玩具");

        typeAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,typeList);
        supptype.setAdapter(typeAdapter);

        timeList = new ArrayList<>();
        timeList .add("到期日前");
        timeList .add("一個月前");
        timeList .add("三個禮拜前");
        timeList .add("二個禮拜前");
        timeList .add("一個禮拜前");
        timeList .add("一天前");
        timeList .add("當天");

        timeAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,timeList);
        supptime.setAdapter(timeAdapter);

        //日期
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(
                        supp.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        dateSetListener,year,month,day
                );

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();


            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                month = month+1;

                String thedate = year +"/"+ month + "/"+ day;

                date.setText(thedate);


            }
        };

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String,String> map = new HashMap<>();
                map.put("userID",uid);
                map.put("suppbrand",brand.getText().toString());
                map.put("suppname",name.getText().toString());
                map.put("supptype",supptype.getSelectedItem().toString());
                map.put("date",date.getText().toString());
                map.put("supptime",supptime.getSelectedItem().toString());
                db.collection("PetSupp").document().set(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"已更新用品資料", LENGTH_SHORT).show();
                        }
                    }
                });



            }
        });

        //返回鍵
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(supp.this,addsupp.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void datePicker(View v){
         calendar = Calendar.getInstance();
    }


    private void createNotificationChannel(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "LembitReminderChannel";
            String description = "Channel for Lembit Reminder";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("noitfyLembit",name,importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

}
