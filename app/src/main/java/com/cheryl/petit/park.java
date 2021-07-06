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


public class park extends AppCompatActivity {
    private ImageButton back;
    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    private static final String TAG = "FirestoreSearchActivity";
    private EditText search;
    private FirestoreRecyclerAdapter firestoreRecyclerAdapter;
    private RecyclerView parklist;
    Query query = firebaseFirestore.collection("Park");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park);
        back = findViewById(R.id.back);
        search = findViewById(R.id.search);
        parklist = findViewById(R.id.parklist);
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
                    q = firebaseFirestore.collection("Park").orderBy("Parkreigon",Query.Direction.ASCENDING);
                }
                else{
                    q = firebaseFirestore.collection("Park").whereEqualTo("Parkcity",editable.toString()).orderBy("Parkreigon",Query.Direction.ASCENDING);
                }
                FirestoreRecyclerOptions<Parkmodel> options = new FirestoreRecyclerOptions
                        .Builder<Parkmodel>()
                        .setQuery(q,Parkmodel.class)
                        .build();
                firestoreRecyclerAdapter.updateOptions(options);
            }
        });

        FirestoreRecyclerOptions<Parkmodel> options = new FirestoreRecyclerOptions
                .Builder<Parkmodel>()
                .setLifecycleOwner(this)
                .setQuery( query, new SnapshotParser<Parkmodel>() {
                    @NonNull
                    @Override
                    public Parkmodel parseSnapshot(@NonNull DocumentSnapshot snapshot) {
                        Parkmodel parkData = snapshot.toObject(Parkmodel.class);
                        String itemId = snapshot.getId();
                        parkData.setItem_id(itemId);
                        return parkData;
                    }
                })
                .build();

        firestoreRecyclerAdapter = new FirestoreRecyclerAdapter<Parkmodel, ParkViewHolder>(options) {
            @NonNull
            @Override
            public ParkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_row_park, parent, false);
                return new ParkViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull ParkViewHolder holder, final int position, @NonNull Parkmodel parkmodel) {

                holder.name.setText(parkmodel.getParkname());
                holder.city.setText(parkmodel.getParkcity());
                holder.reigon.setText(parkmodel.getParkreigon());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(),Parkpage.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("key",parkmodel);
                        intent.putExtra("bundle",bundle);
                        view.getContext().startActivity(intent);
                    }
                });
            }
        };



        parklist.setHasFixedSize(true);
        parklist.setLayoutManager(new LinearLayoutManager(this));
        parklist.setAdapter(firestoreRecyclerAdapter);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(park.this, search.class);
                startActivity(intent);
                finish();
            }
        });
    }





    private class ParkViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView city;
        private TextView reigon;

        public ParkViewHolder(@NonNull View itemView) {
            super(itemView);
            //parkname:使用於列表,park_name:使用於景點介紹
            name = itemView.findViewById(R.id.parkname);
            city = itemView.findViewById(R.id.parkcity);
            reigon = itemView.findViewById(R.id.parkreigon);

        }
    }
}