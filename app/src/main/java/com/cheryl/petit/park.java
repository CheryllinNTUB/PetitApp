package com.cheryl.petit;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.firebase.ui.firestore.SnapshotParser;
import com.firebase.ui.firestore.paging.FirestorePagingAdapter;
import com.firebase.ui.firestore.paging.FirestorePagingOptions;
import com.firebase.ui.firestore.paging.LoadingState;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import java.util.ArrayList;


public class park extends AppCompatActivity {
    private ImageButton back;
    private FirebaseFirestore firebaseFirestore;
    FirestorePagingAdapter firestoreRecyclerAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park);
        back = findViewById(R.id.back);
        recyclerView = findViewById(R.id.parklist);
        firebaseFirestore = FirebaseFirestore.getInstance();
        Query query = firebaseFirestore.collection("Park");

        PagedList.Config config = new PagedList.Config.Builder()
                .setInitialLoadSizeHint(10)
                .setPageSize(3)
                .build();

        FirestorePagingOptions<ParkData> opinions = new FirestorePagingOptions
                .Builder<ParkData>()
                .setLifecycleOwner(this)
                .setQuery(query, config, new SnapshotParser<ParkData>() {
                    @NonNull
                    @Override
                    public ParkData parseSnapshot(@NonNull DocumentSnapshot snapshot) {
                        ParkData parkData = snapshot.toObject(ParkData.class);
                        String itemId = snapshot.getId();
                        parkData.setItem_id(itemId);
                        return parkData;
                    }
                })
                .build();

        firestoreRecyclerAdapter = new FirestorePagingAdapter<ParkData, ParkViewHolder>(opinions) {
            @NonNull
            @Override
            public ParkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_row_park, parent, false);
                return new ParkViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull ParkViewHolder holder, int position, @NonNull ParkData model) {

                holder.name.setText(model.getParkname());
                holder.address.setText(model.getParkAddress());
            }

            @Override
            protected void onLoadingStateChanged(@NonNull LoadingState state){
                super.onLoadingStateChanged(state);

                switch (state){

                    case LOADING_INITIAL:
                        Log.d("PAGING_LOG","loading data");
                        break;
                    case LOADING_MORE:
                        Log.d("PAGING_LOG","loading next page");
                        break;
                    case FINISHED:
                        Log.d("PAGING_LOG","all data loaded");
                        break;
                    case ERROR:
                        Log.d("PAGING_LOG","loading error");
                        break;
                    case LOADED:
                        Log.d("PAGING_LOG","total items loaded");
                        break;

                }
            }
        };

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(firestoreRecyclerAdapter);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.custom_spinner,
                getResources().getStringArray(R.array.list));


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
        private TextView address;

        public ParkViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.parkname);
            address = itemView.findViewById(R.id.parkaddress);
        }
    }
}