package com.cheryl.petit;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.firebase.ui.firestore.SnapshotParser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;


public class restaurant extends AppCompatActivity {
    private ImageButton back;
    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    private static final String TAG = "FirestoreSearchActivity";
    private EditText search;
    private FirestoreRecyclerAdapter firestoreRecyclerAdapter;
    private RecyclerView restaurantlist;
    Query query = firebaseFirestore.collection("Restaurants");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        back = findViewById(R.id.back);
        search = findViewById(R.id.search);
        restaurantlist = findViewById(R.id.restaurantlist);
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
                    q = firebaseFirestore.collection("Restaurants").orderBy("Restreigon",Query.Direction.ASCENDING);
                }
                else{
                    q = firebaseFirestore.collection("Restaurants").whereEqualTo("Restcity",editable.toString()).orderBy("Restreigon",Query.Direction.ASCENDING);
                }
                FirestoreRecyclerOptions<Restaurantmodel> options = new FirestoreRecyclerOptions
                        .Builder<Restaurantmodel>()
                        .setQuery(q,Restaurantmodel.class)
                        .build();
                firestoreRecyclerAdapter.updateOptions(options);
            }
        });

        FirestoreRecyclerOptions<Restaurantmodel> options = new FirestoreRecyclerOptions
                .Builder<Restaurantmodel>()
                .setLifecycleOwner(this)
                .setQuery( query, new SnapshotParser<Restaurantmodel>() {
                    @NonNull
                    @Override
                    public Restaurantmodel parseSnapshot(@NonNull DocumentSnapshot snapshot) {
                        Restaurantmodel restaurantData = snapshot.toObject(Restaurantmodel.class);
                        String itemId = snapshot.getId();
                        restaurantData.setItem_id(itemId);
                        return restaurantData;
                    }
                })
                .build();


        firestoreRecyclerAdapter = new FirestoreRecyclerAdapter<Restaurantmodel, RestaurantViewHolder>(options) {
            @NonNull
            @Override
            public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_row_restaurant, parent, false);
                return new RestaurantViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull RestaurantViewHolder holder, final int position, @NonNull Restaurantmodel restaurantmodel) {

                holder.name.setText(restaurantmodel.getRestname());
                holder.city.setText(restaurantmodel.getRestcity());
                holder.reigon.setText(restaurantmodel.getRestreigon());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(),Restaurantpage.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("key",restaurantmodel);
                        intent.putExtra("bundle",bundle);
                        view.getContext().startActivity(intent);

                    }
                });
            }
        };



        restaurantlist.setHasFixedSize(true);
        restaurantlist.setLayoutManager(new LinearLayoutManager(this));
        restaurantlist.setAdapter(firestoreRecyclerAdapter);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(restaurant.this, search.class);
                startActivity(intent);
                finish();
            }
        });
    }





    private class RestaurantViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView city;
        private TextView reigon;

        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);
            //parkname:使用於列表,park_name:使用於景點介紹
            name = itemView.findViewById(R.id.restaurantname);
            city = itemView.findViewById(R.id.restaurantcity);
            reigon = itemView.findViewById(R.id.restaurantreigon);

        }
    }
}