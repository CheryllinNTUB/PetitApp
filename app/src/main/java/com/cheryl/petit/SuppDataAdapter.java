package com.cheryl.petit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class SuppDataAdapter extends FirestoreRecyclerAdapter<Suppmodel,SuppDataAdapter.SuppHolder> {
    public SuppDataAdapter(@NonNull FirestoreRecyclerOptions<Suppmodel> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull SuppDataAdapter.SuppHolder holder, int position, @NonNull Suppmodel model) {
        holder.suppbrand.setText(model.getSuppbrand());
        holder.suppname.setText(model.getSuppname());
        holder.supptype.setText(model.getSupptype());
        holder.date.setText(model.getDate());
        holder.supptime.setText(model.getSupptime());
    }

    @NonNull
    @Override
    public SuppDataAdapter.SuppHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.supprecord,
                parent,false);
        return new SuppDataAdapter.SuppHolder(v);
    }


    public void deleteItem(int position){
        getSnapshots().getSnapshot(position).getReference().delete();
    }

    class SuppHolder extends  RecyclerView.ViewHolder{
        private TextView suppbrand,suppname,supptype,date,supptime;

        public SuppHolder(View itemview){
            super(itemview);
            suppbrand = itemview.findViewById(R.id.suppbrand);
            suppname = itemview.findViewById(R.id.suppname);
            supptype = itemview.findViewById(R.id.supptype);
            date = itemview.findViewById(R.id.date);
            supptime = itemview.findViewById(R.id.supptime);

        }
    }
}



