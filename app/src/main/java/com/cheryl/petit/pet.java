package com.cheryl.petit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;


public class pet extends AppCompatActivity {
    private ImageButton back,add;
    private RecyclerView recyclerView_petdata;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference petref = db.collection("PetData");
    private PetDataAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet);


        back =  findViewById(R.id.back);
        add =findViewById(R.id.add);
        setUpRecyclerView();


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(pet.this, user.class);
                startActivity(intent);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(pet.this, petadd.class);
                startActivity(intent);
            }
        });
    }

    private void setUpRecyclerView(){
        Query query = petref.orderBy("petname",Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Petmodel> options = new FirestoreRecyclerOptions.Builder<Petmodel>()
                .setQuery(query,Petmodel.class)
                .build();

        adapter = new PetDataAdapter(options);
        recyclerView_petdata = findViewById(R.id.recyleview_petdata);
        recyclerView_petdata.setLayoutManager(new LinearLayoutManager(this));
        recyclerView_petdata.setAdapter(adapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                adapter.deleteItem(viewHolder.getAdapterPosition());
            }
        }).attachToRecyclerView(recyclerView_petdata);


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
