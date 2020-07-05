package com.cheryl.petit;
//使用於小幫手

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyleViewAdapter extends  RecyclerView.Adapter<HelpViewHolder>{

    private Context context;
    private List<HelptipData> HelptipList;

    public RecyleViewAdapter(Context context,List<HelptipData> HelptipList){
        this.context = context;
        this.HelptipList = HelptipList;
    }




    @Override
    public HelpViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_row_item,parent,false);

        return new HelpViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HelpViewHolder holder, int position) {

        holder.imageView.setImageResource(HelptipList.get(position).getHelpimg());
        holder.Help_name.setText(HelptipList.get(position).getHelpname());
        holder.Help_description.setText(HelptipList.get(position).getHelpdescription());
    }

    @Override
    public int getItemCount() {
        return HelptipList.size();
    }
}

class  HelpViewHolder extends RecyclerView.ViewHolder{

    ImageView imageView;
    TextView Help_name,Help_description;
    CardView cardview;

    public HelpViewHolder(@NonNull View itemView){
        super(itemView);

        imageView = itemView.findViewById(R.id.help_foodtip);
        Help_name = itemView.findViewById(R.id.helptitle);
        Help_description = itemView.findViewById(R.id.helpcontent);
        cardview = itemView.findViewById(R.id.cardview);
    }

}





