package com.cheryl.petit;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.firebase.ui.firestore.SnapshotParser;
import com.firebase.ui.firestore.paging.FirestorePagingAdapter;
import com.firebase.ui.firestore.paging.FirestorePagingOptions;
import com.firebase.ui.firestore.paging.LoadingState;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import java.util.ArrayList;


public class salon extends AppCompatActivity {
    private ImageButton back;
    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    private static final String TAG = "FirestoreSearchActivity";
    private EditText search;
    private FirestoreRecyclerAdapter firestoreRecyclerAdapter;
    private RecyclerView salonlist;
    Query query = firebaseFirestore.collection("Salon");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon);
        back = findViewById(R.id.back);
        search = findViewById(R.id.search);
        salonlist = findViewById(R.id.salonlist);
        firebaseFirestore = FirebaseFirestore.getInstance();

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
                    q = firebaseFirestore.collection("Salon").orderBy("Salonreigon",Query.Direction.ASCENDING);
                }
                else{
                    q = firebaseFirestore.collection("Salon").whereEqualTo("Saloncity",editable.toString()).orderBy("Salonreigon",Query.Direction.ASCENDING);
                }
                FirestoreRecyclerOptions<Salonmodel> options = new FirestoreRecyclerOptions
                        .Builder<Salonmodel>()
                        .setQuery(q,Salonmodel.class)
                        .build();
                firestoreRecyclerAdapter.updateOptions(options);
            }
        });

        FirestoreRecyclerOptions<Salonmodel> options = new FirestoreRecyclerOptions
                .Builder<Salonmodel>()
                .setLifecycleOwner(this)
                .setQuery( query, new SnapshotParser<Salonmodel>() {
                    @NonNull
                    @Override
                    public Salonmodel parseSnapshot(@NonNull DocumentSnapshot snapshot) {
                        Salonmodel salonData = snapshot.toObject(Salonmodel.class);
                        String itemId = snapshot.getId();
                        salonData.setItem_id(itemId);
                        return salonData;
                    }
                })
                .build();


        firestoreRecyclerAdapter = new FirestoreRecyclerAdapter<Salonmodel, SalonViewHolder>(options) {
            @NonNull
            @Override
            public SalonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_row_salon, parent, false);
                return new SalonViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull SalonViewHolder holder, final int position, @NonNull Salonmodel salonmodel) {

                holder.name.setText(salonmodel.getSalnname());
                holder.city.setText(salonmodel.getSalncity());
                holder.reigon.setText(salonmodel.getSalnreigon());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(),Salonpage.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("key",salonmodel);
                        intent.putExtras(bundle);
                        intent.putExtra("bundle",bundle);
                        view.getContext().startActivity(intent);
                    }
                });
            }
        };



        salonlist.setHasFixedSize(true);
        salonlist.setLayoutManager(new LinearLayoutManager(this));
        salonlist.setAdapter(firestoreRecyclerAdapter);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(salon.this, search.class);
                startActivity(intent);
                finish();
            }
        });
    }





    private class SalonViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView city;
        private TextView reigon;

        public SalonViewHolder(@NonNull View itemView) {
            super(itemView);
            //parkname:使用於列表,park_name:使用於景點介紹
            name = itemView.findViewById(R.id.salonname);
            city = itemView.findViewById(R.id.saloncity);
            reigon = itemView.findViewById(R.id.salonreigon);

        }
    }
}