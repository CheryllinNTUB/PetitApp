package com.cheryl.petit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.firestore.FirebaseFirestore;

public class Hotelpage extends Activity {
    private FirebaseFirestore firebaseFirestore;
    private ImageButton back;
    private Button findon_net,park_map,add_love;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotelpage);
        findon_net = findViewById(R.id.findon_net);
        park_map = findViewById(R.id.park_map);
        add_love = findViewById(R.id.add_love);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        Hotelmodel hotelmodel = (Hotelmodel) bundle.getSerializable("key");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Hotelpage.this, pet.class);
                startActivity(intent);
            }
        });
    }
}
