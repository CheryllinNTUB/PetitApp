package com.cheryl.petit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class CalDataAdapter extends FirestoreRecyclerAdapter<Calmodel,CalDataAdapter.CalHolder> {

    public CalDataAdapter(@NonNull FirestoreRecyclerOptions<Calmodel> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull CalDataAdapter.CalHolder holder, int position, @NonNull Calmodel model) {
        holder.petname.setText(model.getPetname());
        holder.foodtype.setText(model.getFoodtype());
        holder.foodname.setText(model.getFoodname());
        holder.eatcal.setText(model.getEattotalcal());
        holder.meal.setText(model.getMealkind());
        holder.dated.setText(model.getDated());
        holder.recal.setText(model.getRecal());

    }

    @NonNull
    @Override
    public CalDataAdapter.CalHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.calrecord,
                parent,false);
        return new CalDataAdapter.CalHolder(v);
    }


    public void deleteItem(int position){
        getSnapshots().getSnapshot(position).getReference().delete();
    }

    class CalHolder extends  RecyclerView.ViewHolder{
        private TextView petname,foodtype,foodname,eatcal,meal,dated,recal;

        public CalHolder(View itemview){
            super(itemview);
            petname = itemview.findViewById(R.id.petname);
            foodtype = itemview.findViewById(R.id.foodtype);
            foodname = itemview.findViewById(R.id.foodname);
            eatcal = itemview.findViewById(R.id.eattotalcal);
            meal = itemview.findViewById(R.id.meal);
            dated = itemview.findViewById(R.id.dated);
            recal = itemview.findViewById(R.id.recal);

        }
    }
}

