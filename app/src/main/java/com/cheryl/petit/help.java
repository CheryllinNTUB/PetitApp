package com.cheryl.petit;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class  help extends Fragment {

    RecyclerView recyclerView;
    ArrayList<HelptipData> helptipDataList;
    HelptipData helptipData;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_help, container, false);

       recyclerView =(RecyclerView) v.findViewById(R.id.recyleview);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(help.this.getContext(),1);
        recyclerView.setLayoutManager(gridLayoutManager);
        helptipDataList = new ArrayList<>();
        helptipData = new HelptipData("關於寵物的餵食小知識...","餵對好食物，讓牠吃的快樂又安心",R.drawable.helpfood);
            helptipDataList.add(helptipData);

        helptipData = new HelptipData("關於寵物的保健小知識...","毛孩也要養生!來看牠們的保健小秘密",R.drawable.helphealth);
            helptipDataList.add(helptipData);

        helptipData = new HelptipData("關於寵物的最新活動...","最新的寵物展覽及活動資訊都在這!",R.drawable.helpnews);
            helptipDataList.add(helptipData);

        helptipData = new HelptipData("關於寵物的用品小知識...","挑對用品，主人毛孩都開心",R.drawable.helpsupplies);
            helptipDataList.add(helptipData);

        RecyleViewAdapter recyleViewAdapter = new RecyleViewAdapter(help.this.getContext(),helptipDataList);
        recyclerView.setAdapter(recyleViewAdapter);

        return v;
    }
}