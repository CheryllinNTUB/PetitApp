package com.cheryl.petit;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HelpDataAdapter extends RecyclerView.Adapter<HelpViewHpler> {


    private Context context;
    private List<Helpmodel> helpmodel;

    public HelpDataAdapter(Context context, List<Helpmodel> helpmodel){
        this.context = context;
        this.helpmodel = helpmodel;
    }

    @NonNull
    @Override
    public HelpViewHpler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_row_item,parent,false);

        return new HelpViewHpler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HelpViewHpler holder, int position) {

        holder.imageView.setImageResource(helpmodel.get(position).getHelpimg());
        holder.title.setText(helpmodel.get(position).getHelpname());
        holder.content.setText(helpmodel.get(position).getHelpdescription());
    }

    @Override
    public int getItemCount() {
        return helpmodel.size();
    }
}
    class HelpViewHpler extends RecyclerView.ViewHolder{

    ImageView imageView;
    TextView title,content;
    CardView cardView;


    public HelpViewHpler(@NonNull View itemview){
    super(itemview);

    imageView = itemview.findViewById(R.id.helpimg);
    title = itemview.findViewById(R.id.helptitle);
    content = itemview.findViewById(R.id.helpcontent);
    cardView = itemview.findViewById(R.id.cardview);
    }

}













