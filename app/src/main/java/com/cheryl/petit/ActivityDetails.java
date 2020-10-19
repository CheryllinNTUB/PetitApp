package com.cheryl.petit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityDetails extends AppCompatActivity {

    private ImageView act_img;
    private TextView act_title,act_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        act_title = findViewById(R.id.activity_title);
        act_img = findViewById(R.id.activity_image);
        act_content = findViewById(R.id.activity_content);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null){

           act_title.setText(bundle.getString("Title"));
            act_content.setText(bundle.getString("content"));
            act_img.setImageResource(bundle.getInt("Image"));

        }
    }
}
