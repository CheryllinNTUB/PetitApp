package com.cheryl.petit;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.squareup.picasso.Picasso;

import java.util.List;


//用於顯示公園資料
public class ParkDataAdapter extends FirestoreRecyclerAdapter<Parkmodel, ParkDataAdapter.ParkHolder> {


    public ParkDataAdapter(@NonNull FirestoreRecyclerOptions<Parkmodel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ParkHolder holder, int position, @NonNull Parkmodel model) {
        //Picasso.get().load(model.getPethead()).into(holder.head);
        holder.name.setText(model.getParkname());
        holder.address.setText(model.getParkAddress());
        //holder.details.setText(model.getParkdetails());


    }

    @NonNull
    @Override
    public ParkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_row_park,
                parent,false);
        return new ParkHolder(v);
    }


    class ParkHolder extends  RecyclerView.ViewHolder{
        //private ImageView head;
        private TextView address,name,details;

        public ParkHolder(View itemview){
            super(itemview);
            name = itemview.findViewById(R.id.parkname);
            address = itemview.findViewById(R.id.parkaddress);
            //details = itemview.findViewById(R.id.);
        }
    }
}

