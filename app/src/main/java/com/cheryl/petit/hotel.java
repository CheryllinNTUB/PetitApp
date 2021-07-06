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

public class hotel extends AppCompatActivity {
    private ImageButton back;
    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    private static final String TAG = "FirestoreSearchActivity";
    private EditText search;
    private FirestoreRecyclerAdapter firestoreRecyclerAdapter;
    private RecyclerView hotellist;
    Query query = firebaseFirestore.collection("Hotel");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        back = findViewById(R.id.back);
        hotellist = findViewById(R.id.hotellist);
        search = findViewById(R.id.search);
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
                    q = firebaseFirestore.collection("Hotel").orderBy("Hotelreigon",Query.Direction.ASCENDING);
                }
                else{
                    q = firebaseFirestore.collection("Hotel").whereEqualTo("Hotelcity",editable.toString()).orderBy("Hotelreigon",Query.Direction.ASCENDING);
                }
                FirestoreRecyclerOptions<Hotelmodel> options = new FirestoreRecyclerOptions
                        .Builder<Hotelmodel>()
                        .setQuery(q,Hotelmodel.class)
                        .build();
                firestoreRecyclerAdapter.updateOptions(options);
            }
        });

        FirestoreRecyclerOptions<Hotelmodel> options = new FirestoreRecyclerOptions
                .Builder<Hotelmodel>()
                .setLifecycleOwner(this)
                .setQuery( query, new SnapshotParser<Hotelmodel>() {
                    @NonNull
                    @Override
                    public Hotelmodel parseSnapshot(@NonNull DocumentSnapshot snapshot) {
                        Hotelmodel hotelData = snapshot.toObject(Hotelmodel.class);
                        String itemId = snapshot.getId();
                        hotelData.setItem_id(itemId);
                        return hotelData;
                    }
                })
                .build();


        firestoreRecyclerAdapter = new FirestoreRecyclerAdapter<Hotelmodel, HotelViewHolder>(options) {
            @NonNull
            @Override
            public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_row_hotel, parent, false);
                return new HotelViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull HotelViewHolder holder, final int position, @NonNull Hotelmodel hotelmodel) {

                holder.name.setText(hotelmodel.getHotelname());
                holder.city.setText(hotelmodel.getHotelcity());
                holder.reigon.setText(hotelmodel.getHotelreigon());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(),Hotelpage.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("key",hotelmodel);
                        intent.putExtra("bundle",bundle);
                        view.getContext().startActivity(intent);
                    }
                });
            }
        };

        hotellist.setHasFixedSize(true);
        hotellist.setLayoutManager(new LinearLayoutManager(this));
        hotellist.setAdapter(firestoreRecyclerAdapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hotel.this, search.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private class HotelViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView city;
        private TextView reigon;

        public HotelViewHolder(@NonNull View itemView) {
            super(itemView);
            //parkname:使用於列表,park_name:使用於景點介紹
            name = itemView.findViewById(R.id.hotelname);
            city = itemView.findViewById(R.id.hotelcity);
            reigon = itemView.findViewById(R.id.hotelreigon);

        }
    }
}