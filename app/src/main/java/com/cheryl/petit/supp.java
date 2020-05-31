package com.cheryl.petit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class supp extends AppCompatActivity {
    private ImageButton back;
    private Button choosedate;
    private EditText date;
    private Spinner supptype,supptime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supp);
        choosedate = findViewById(R.id.choosedate);
        back = findViewById(R.id.back);
        date = findViewById(R.id.date);
        choosedate = findViewById(R.id.choosedate);
        supptime = findViewById(R.id.supptime);
        supptype = findViewById(R.id.supptype);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.custom_spinner,
                getResources().getStringArray(R.array.list)
        );

        choosedate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                new DatePickerDialog(supp.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        String dateTime = String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(day);
                        date.setText(dateTime);

                    }
                },year,month,day).show();

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(supp.this,homepage.class);
                intent.putExtra("supp",3);
                startActivity(intent);
                finish();
            }
        });
    }


    public void datePicker(View v){
        Calendar calendar = Calendar.getInstance();


    }

}
