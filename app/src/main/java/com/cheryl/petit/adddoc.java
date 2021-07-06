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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SearchView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class adddoc extends AppCompatActivity {
    private RecyclerView recyclerView_docdata;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String TAG = "FirestoreSearchActivity";
    private EditText search;
    private CollectionReference docref = db.collection("DocData");
    private DocDataAdapter adapter;
    private ImageButton back,add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddoc);


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
                    q = db.collection("DocData").orderBy("docday",Query.Direction.ASCENDING);

                }
                else {
                    q = db.collection("DocData").whereEqualTo("petname",editable.toString())
                            .orderBy("docday",Query.Direction.ASCENDING);
                }

                FirestoreRecyclerOptions<Docmodel> options = new FirestoreRecyclerOptions
                        .Builder<Docmodel>()
                        .setQuery(q,Docmodel.class)
                        .build();
                adapter.updateOptions(options);
            }
        });



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(adddoc.this,record.class);
                startActivity(intent);
                finish();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(adddoc.this, doc.class);
                startActivity(intent);
            }
        });

    }

    private void filter(String toString) {
        ArrayList<Docmodel> filterList = new ArrayList<>();

    }

    private void setUpRecyclerView(){
        Query query = docref.orderBy("docday",Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Docmodel> options = new FirestoreRecyclerOptions.Builder<Docmodel>()
                .setQuery(query,Docmodel.class)
                .build();

        adapter = new DocDataAdapter(options);
        recyclerView_docdata = findViewById(R.id.recyleview_docdata);
        recyclerView_docdata.setLayoutManager(new LinearLayoutManager(this));
        recyclerView_docdata.setAdapter(adapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                adapter.deleteItem(viewHolder.getAdapterPosition());
            }
        }).attachToRecyclerView(recyclerView_docdata);

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