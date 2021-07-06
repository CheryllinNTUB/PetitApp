package com.cheryl.petit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

//用於顯示看病資料
public class DocDataAdapter extends FirestoreRecyclerAdapter<Docmodel,DocDataAdapter.DocHolder> {

    public DocDataAdapter(@NonNull FirestoreRecyclerOptions<Docmodel> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull DocDataAdapter.DocHolder holder, int position, @NonNull Docmodel model) {
        holder.docday.setText(model.getDocday());
        holder.whysick.setText(model.getWhysick());
        holder.hospital.setText(model.getHospital());
        holder.note.setText(model.getSicknote());
        holder.backdoc.setText(model.getBacktodoc());
        holder.backdocday.setText(model.getBacktodocday());
        holder.petname.setText(model.getPetname());
    }

    @NonNull
    @Override
    public DocDataAdapter.DocHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.docrecord,
                parent,false);
        return new DocDataAdapter.DocHolder(v);
    }


    public void deleteItem(int position){
        getSnapshots().getSnapshot(position).getReference().delete();
    }

    class DocHolder extends  RecyclerView.ViewHolder{
        private TextView docday,whysick,hospital,note,backdoc,backdocday,petname;

        public DocHolder(View itemview){
            super(itemview);
            docday = itemview.findViewById(R.id.docday);
            whysick = itemview.findViewById(R.id.whysick);
            hospital = itemview.findViewById(R.id.hospital);
            note = itemview.findViewById(R.id.note);
            backdoc = itemview.findViewById(R.id.backdoc);
            backdocday = itemview.findViewById(R.id.backdocday);
            petname = itemview.findViewById(R.id.petname);

        }
    }
}