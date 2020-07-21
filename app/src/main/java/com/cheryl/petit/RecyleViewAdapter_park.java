package com.cheryl.petit;

//使用於公園搜尋
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyleViewAdapter_park extends RecyclerView.Adapter<ParkViewHolder>{

    private Context context;
    private List<ParkData> ParkList;

    @Override
    public ParkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_row_park,parent,false);
        return new ParkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ParkViewHolder holder, int position) {

        holder.Park_name.setText(ParkList.get(position).getParkname());
        holder.Park_address.setText(ParkList.get(position).getParkDescription());
       /* holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, park_details.class);
                context.startActivity(intent);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return ParkList.size();
    }

    public RecyleViewAdapter_park(Context context, List<ParkData> ParkList){
        this.context = context;
        this.ParkList = ParkList;
    }
}

class ParkViewHolder extends RecyclerView.ViewHolder{

    TextView Park_name,Park_address;
    CardView cardview;

    public ParkViewHolder(@NonNull View itemView){
        super(itemView);

        Park_name = itemView.findViewById(R.id.parkname);
        Park_address = itemView.findViewById(R.id.parkaddress);
        cardview = itemView.findViewById(R.id.cardview);
    }

}
