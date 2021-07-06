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

public class hospital extends AppCompatActivity {
 private ImageButton back;
 private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
 private static final String TAG = "FirestoreSearchActivity";
 private EditText search;
 private FirestoreRecyclerAdapter firestoreRecyclerAdapter;
 private RecyclerView hospitallist;
 Query query = firebaseFirestore.collection("Hospital");

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_hospital);
  back = findViewById(R.id.back);
  hospitallist = findViewById(R.id.hospitallist);
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
     q = firebaseFirestore.collection("Hospital").orderBy("Hospitalreigon",Query.Direction.ASCENDING);
    }
    else{
     q = firebaseFirestore.collection("Hospital").whereEqualTo("Hospitalcity",editable.toString()).orderBy("Hospitalreigon",Query.Direction.ASCENDING);
    }
    FirestoreRecyclerOptions<Hospitalmodel> options = new FirestoreRecyclerOptions
            .Builder<Hospitalmodel>()
            .setQuery(q,Hospitalmodel.class)
            .build();
    firestoreRecyclerAdapter.updateOptions(options);
   }
  });


  FirestoreRecyclerOptions<Hospitalmodel> options = new FirestoreRecyclerOptions
          .Builder<Hospitalmodel>()
          .setLifecycleOwner(this)
          .setQuery( query, new SnapshotParser<Hospitalmodel>() {
           @NonNull
           @Override
           public Hospitalmodel parseSnapshot(@NonNull DocumentSnapshot snapshot) {
            Hospitalmodel hospitalData = snapshot.toObject(Hospitalmodel.class);
            String itemId = snapshot.getId();
            hospitalData.setItem_id(itemId);
            return hospitalData;
           }
          })
          .build();

  firestoreRecyclerAdapter = new FirestoreRecyclerAdapter<Hospitalmodel, HospitalViewHolder>(options) {
   @NonNull
   @Override
   public HospitalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_row_hospital, parent, false);
    return new HospitalViewHolder(view);
   }

   @Override
   protected void onBindViewHolder(@NonNull HospitalViewHolder holder, final int position, @NonNull Hospitalmodel hospitalmodel) {

    holder.name.setText(hospitalmodel.getHospitalname());
    holder.city.setText(hospitalmodel.getHospitalcity());
    holder.reigon.setText(hospitalmodel.getHospitalreigon());
    holder.itemView.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
      Intent intent = new Intent(view.getContext(),Hospitalpage.class);
      Bundle bundle = new Bundle();
      bundle.putSerializable("key",hospitalmodel);
      intent.putExtra("bundle",bundle);
      view.getContext().startActivity(intent);
     }
    });
   }
  };



  hospitallist.setHasFixedSize(true);
  hospitallist.setLayoutManager(new LinearLayoutManager(this));
  hospitallist.setAdapter(firestoreRecyclerAdapter);



  back.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {
    Intent intent = new Intent(hospital.this, search.class);
    startActivity(intent);
    finish();
   }
  });

 }


 private class HospitalViewHolder extends RecyclerView.ViewHolder {

  private TextView name;
  private TextView city;
  private TextView reigon;

  public HospitalViewHolder(@NonNull View itemView) {
   super(itemView);
   //parkname:使用於列表,park_name:使用於景點介紹
   name = itemView.findViewById(R.id.hospitalname);
   city = itemView.findViewById(R.id.hospitalcity);
   reigon = itemView.findViewById(R.id.hospitalreigon);

  }
 }
}