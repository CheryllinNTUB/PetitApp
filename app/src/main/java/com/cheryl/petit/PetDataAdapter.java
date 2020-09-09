package com.cheryl.petit;


import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;


//用於顯示寵物資料
public class PetDataAdapter extends FirestoreRecyclerAdapter<Petmodel,PetDataAdapter.PetHolder> {


    public PetDataAdapter(@NonNull FirestoreRecyclerOptions<Petmodel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PetHolder holder, int position, @NonNull Petmodel model) {
        Picasso.get().load(model.getPethead()).into(holder.head);
        holder.name.setText(model.getPetname());
        holder.kind.setText(model.getPetkind());
        holder.variety.setText(model.getPetvariety());
        holder.sex.setText(model.getPetsex());
        holder.birthday.setText(model.getPetbirthday());

    }

    @NonNull
    @Override
    public PetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.petrecord,
                parent,false);
        return new PetHolder(v);
    }

    public void deleteItem(int position){
        getSnapshots().getSnapshot(position).getReference().delete();
    }



    class PetHolder extends  RecyclerView.ViewHolder{
        private ImageView head;
        private TextView  name,kind,variety,sex,birthday;

        public PetHolder(View itemview){
            super(itemview);
            head = itemview.findViewById(R.id.pethead);
            name = itemview.findViewById(R.id.petname);
            kind = itemview.findViewById(R.id.petkind);
            variety = itemview.findViewById(R.id.petvariety);
            sex = itemview.findViewById(R.id.petsex);
            birthday = itemview.findViewById(R.id.petbirthday);
        }
    }
}

