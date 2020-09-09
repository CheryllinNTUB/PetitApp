package com.cheryl.petit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class addcal extends AppCompatActivity {
    private RecyclerView recyclerView_caldata;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference calref = db.collection("Petpermeal");
    private CalDataAdapter adapter;
    private ImageButton back,add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcal);

        back =  findViewById(R.id.back);
        add =findViewById(R.id.add);
        setUpRecyclerView();


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(addcal.this,record.class);
                startActivity(intent);
                finish();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(addcal.this, cal.class);
                startActivity(intent);
            }
        });
    }


    private void setUpRecyclerView(){
        Query query = calref.orderBy("petname",Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Calmodel> options = new FirestoreRecyclerOptions.Builder<Calmodel>()
                .setQuery(query,Calmodel.class)
                .build();

        adapter = new CalDataAdapter(options);
        recyclerView_caldata = findViewById(R.id.recyleview_caldata);
        recyclerView_caldata.setLayoutManager(new LinearLayoutManager(this));
        recyclerView_caldata.setAdapter(adapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                adapter.deleteItem(viewHolder.getAdapterPosition());
            }
        }).attachToRecyclerView(recyclerView_caldata);

    }

    @Override
    protected void onStart(){
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop(){
        super.onStop();
        adapter.stopListening();
    }
}

