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

public class ActivityDataAdapter extends RecyclerView.Adapter<ActivityViewHelper> {


    private Context context;
    private List<Activitymodel> activitymodel;

    public ActivityDataAdapter(Context context, List<Activitymodel> activitymodel){
        this.context = context;
        this.activitymodel = activitymodel;
    }

    @NonNull
    @Override
    public ActivityViewHelper onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_row_activity,parent,false);

        return new ActivityViewHelper(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  ActivityViewHelper holder, int position) {

        holder.image.setImageResource(activitymodel.get(position).getImage());
        holder.name.setText(activitymodel.get(position).getActivityName());
        holder.content.setText(activitymodel.get(position).getActivityContent());
    }

    @Override
    public int getItemCount() {
        return activitymodel.size();
    }
}
class  ActivityViewHelper extends RecyclerView.ViewHolder{

    ImageView image;
    TextView name,content;
    CardView cardView;


    public  ActivityViewHelper(@NonNull View itemview){
        super(itemview);

        image = itemview.findViewById(R.id.activityimage);
        name = itemview.findViewById(R.id.activitytitle);
        content = itemview.findViewById(R.id.activitycontent);
        cardView = itemview.findViewById(R.id.cardview);
    }

}