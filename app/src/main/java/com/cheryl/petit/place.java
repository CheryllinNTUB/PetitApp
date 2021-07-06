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


public class place extends AppCompatActivity {
    private ImageButton back;
    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    private static final String TAG = "FirestoreSearchActivity";
    private EditText search;
    private FirestoreRecyclerAdapter firestoreRecyclerAdapter;
    private RecyclerView placelist;
    Query query = firebaseFirestore.collection("Place");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        back = findViewById(R.id.back);
        search = findViewById(R.id.search);
        placelist = findViewById(R.id.placelist);
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
                    q = firebaseFirestore.collection("Place").orderBy("Placereigon",Query.Direction.ASCENDING);
                }
                else{
                    q = firebaseFirestore.collection("Place").whereEqualTo("Placecity",editable.toString()).orderBy("Placereigon",Query.Direction.ASCENDING);
                }
                FirestoreRecyclerOptions<Placemodel> options = new FirestoreRecyclerOptions
                        .Builder<Placemodel>()
                        .setQuery(q,Placemodel.class)
                        .build();
                firestoreRecyclerAdapter.updateOptions(options);
            }
        });

        FirestoreRecyclerOptions<Placemodel> options = new FirestoreRecyclerOptions
                .Builder<Placemodel>()
                .setLifecycleOwner(this)
                .setQuery( query, new SnapshotParser<Placemodel>() {
                    @NonNull
                    @Override
                    public Placemodel parseSnapshot(@NonNull DocumentSnapshot snapshot) {
                        Placemodel placeData = snapshot.toObject(Placemodel.class);
                        String itemId = snapshot.getId();
                        placeData.setItem_id(itemId);
                        return placeData;
                    }
                })
                .build();

        firestoreRecyclerAdapter = new FirestoreRecyclerAdapter<Placemodel, PlaceViewHolder>(options) {
            @NonNull
            @Override
            public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_row_place, parent, false);
                return new PlaceViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull PlaceViewHolder holder, final int position, @NonNull Placemodel placemodel) {

                holder.name.setText(placemodel.getPlacename());
                holder.city.setText(placemodel.getPlacecity());
                holder.reigon.setText(placemodel.getPlacereigon());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(),Placepage.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("key",placemodel);
                        intent.putExtra("bundle",bundle);
                        view.getContext().startActivity(intent);
                    }
                });
            }
        };



        placelist.setHasFixedSize(true);
        placelist.setLayoutManager(new LinearLayoutManager(this));
        placelist.setAdapter(firestoreRecyclerAdapter);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(place.this, search.class);
                startActivity(intent);
                finish();
            }
        });
    }





    private class PlaceViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView city;
        private TextView reigon;

        public PlaceViewHolder(@NonNull View itemView) {
            super(itemView);
            //parkname:使用於列表,park_name:使用於景點介紹
            name = itemView.findViewById(R.id.placename);
            city = itemView.findViewById(R.id.placecity);
            reigon = itemView.findViewById(R.id.placereigon);

        }
    }
}