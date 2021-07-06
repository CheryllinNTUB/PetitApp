package com.cheryl.petit;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class addweight extends AppCompatActivity {
    private RecyclerView recyclerView_weidata;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference weiref = db.collection("PetweightRecord");
    private static final String TAG = "FirestoreSearchActivity";
    private EditText search;
    private WeightDataAdapter adapter;
    private ImageButton back,add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addweight);

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
                    q = db.collection("PetweightRecord").orderBy("petname",Query.Direction.ASCENDING);

                }
                else {
                    q = db.collection("PetweightRecord").whereEqualTo("petname",editable.toString())
                            .orderBy("petweight",Query.Direction.ASCENDING);
                }

                FirestoreRecyclerOptions<Weightmodel> options = new FirestoreRecyclerOptions
                        .Builder<Weightmodel>()
                        .setQuery(q,Weightmodel.class)
                        .build();
                adapter.updateOptions(options);
            }
        });



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(addweight.this,record.class);
                startActivity(intent);
                finish();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(addweight.this, daily.class);
                startActivity(intent);
            }
        });
    }




    private void setUpRecyclerView(){
        Query query = weiref.orderBy("petname",Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Weightmodel> options = new FirestoreRecyclerOptions.Builder<Weightmodel>()
                .setQuery(query,Weightmodel.class)
                .build();


        adapter = new WeightDataAdapter(options);
        recyclerView_weidata = findViewById(R.id.recyleview_weidata);
        recyclerView_weidata.setLayoutManager(new LinearLayoutManager(this));
        recyclerView_weidata.setAdapter(adapter);
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                adapter.deleteItem(viewHolder.getAdapterPosition());

            }
        }).attachToRecyclerView(recyclerView_weidata);

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

