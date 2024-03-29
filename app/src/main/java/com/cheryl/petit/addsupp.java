package com.cheryl.petit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class addsupp extends AppCompatActivity {
    private RecyclerView recyclerView_suppdata;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference suppref = db.collection("PetSupp");
    private static final String TAG = "FirestoreSearchActivity";
    private EditText search;
    private SuppDataAdapter adapter;
    private ImageButton back,add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addsupp);

        back =  findViewById(R.id.back);
        add =findViewById(R.id.add);
        search = findViewById(R.id.search);
        setUpRecyclerView();

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d(TAG,"Searchbox has changed to:"+ editable.toString());
                Query q;
                if (editable.toString().isEmpty()){
                    q = db.collection("PetSupp").orderBy("supptime",Query.Direction.ASCENDING);

                }
                else {
                    q = db.collection("PetSupp").whereEqualTo("supptype",editable.toString())
                            .orderBy("supptime",Query.Direction.ASCENDING);
                }

                FirestoreRecyclerOptions<Suppmodel> options = new FirestoreRecyclerOptions
                        .Builder<Suppmodel>()
                        .setQuery(q,Suppmodel.class)
                        .build();
                adapter.updateOptions(options);
            }
        });




        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(addsupp.this,record.class);
                startActivity(intent);
                finish();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(addsupp.this, supp.class);
                startActivity(intent);
            }
        });
    }


    private void setUpRecyclerView(){
        Query query = suppref.orderBy("suppbrand",Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Suppmodel> options = new FirestoreRecyclerOptions.Builder<Suppmodel>()
                .setQuery(query,Suppmodel.class)
                .build();

        adapter = new SuppDataAdapter(options);
        recyclerView_suppdata = findViewById(R.id.recyleview_suppdata);
        recyclerView_suppdata.setLayoutManager(new LinearLayoutManager(this));
        recyclerView_suppdata.setAdapter(adapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                adapter.deleteItem(viewHolder.getAdapterPosition());
            }
        }).attachToRecyclerView(recyclerView_suppdata);

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

