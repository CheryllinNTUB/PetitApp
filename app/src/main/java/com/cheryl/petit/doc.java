package com.cheryl.petit;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.Calendar;

public class doc extends AppCompatActivity {
    private ImageButton back;
    private Button docday,backdocbtn;
    private EditText date;
    private RadioButton yes,no;
    private Spinner petname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc);
        docday = findViewById(R.id.docday);
        back = findViewById(R.id.back);
        date = findViewById(R.id.date);
        docday = findViewById(R.id.docday);
        backdocbtn = findViewById(R.id.backdocbtn);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        petname = findViewById(R.id.petname);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.custom_spinner,
                getResources().getStringArray(R.array.list)
        );


        docday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                new DatePickerDialog(doc.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        String dateTime = String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(day);
                        date.setText(dateTime);

                    }
                },year,month,day).show();

            }
        });


        backdocbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar d = Calendar.getInstance();
                int year = d.get(Calendar.YEAR);
                int month = d.get(Calendar.MONTH);
                int day = d.get(Calendar.DAY_OF_MONTH);
                new DatePickerDialog(doc.this, new DatePickerDialog.OnDateSetListener() {
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
                Intent intent = new Intent(doc.this,homepage.class);
                intent.putExtra("doc",2);
                startActivity(intent);
                finish();
            }
        });

    }

}
