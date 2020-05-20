package com.cheryl.petit;


import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;


public class help extends Fragment {
    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_help, container, false);

        models = new ArrayList<>();
        models.add(new Model(R.drawable.eatfood,"關於毛孩的餵食小知識","餵對好食物，讓牠吃的開心又健康"));
        models.add(new Model(R.drawable.health,"關於毛小孩的保健小知識","人和毛孩都要養生!來看看毛孩們的健康小秘密"));
        models.add(new Model(R.drawable.psychologically,"關於毛小孩的情緒小知識","和毛孩來場心靈交流吧!"));
        models.add(new Model(R.drawable.petsupplies,"關於採購好的寵物用品","在為毛孩血拚同時，也要記得別當冤大頭!"));
        models.add(new Model(R.drawable.usequestion,"關於系統使用問題","當在使用app遇到問題時，不妨來這裡尋找答案"));

        adapter = new Adapter(models,getActivity());

        viewPager = v.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);

        Integer[] colors_temp ={
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4)
        };

        colors =colors_temp;



        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position<(adapter.getCount() -1)&& position<(colors.length -1)){
                    viewPager.setBackgroundColor((Integer)argbEvaluator.evaluate(positionOffset, colors[position],colors[position +1])) ;

                }else {
                    viewPager.setBackgroundColor(colors[colors.length -1]);
                }

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return v;

    }
    @Override
    public  void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
    }


}