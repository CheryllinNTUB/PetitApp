package com.cheryl.petit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class WeightDataAdapter extends FirestoreRecyclerAdapter<Weightmodel, WeightDataAdapter.WeightHolder> {

    public WeightDataAdapter(@NonNull FirestoreRecyclerOptions<Weightmodel> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull WeightDataAdapter.WeightHolder holder, int position, @NonNull Weightmodel model) {
        holder.petname.setText(model.getPetname());
        holder.petweight.setText(model.getPetweight());
        holder.petkind.setText(model.getPettype());
        holder.daycal.setText(model.getDay_cal());


    }

    @NonNull
    @Override
    public WeightDataAdapter.WeightHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.weightrecord,
                parent,false);
        return new WeightDataAdapter.WeightHolder(v);
    }


    public void deleteItem(int position){
        getSnapshots().getSnapshot(position).getReference().delete();
    }

    class WeightHolder extends  RecyclerView.ViewHolder{
        private TextView petname,petweight,petkind,daycal;

        public WeightHolder(View itemview){
            super(itemview);
            petname = itemview.findViewById(R.id.petname);
            petweight = itemview.findViewById(R.id.petweight);
            petkind = itemview.findViewById(R.id.pettype);
            daycal = itemview.findViewById(R.id.day_cal);

        }
    }
}

