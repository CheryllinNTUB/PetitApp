package com.cheryl.petit;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;
/*使用於小幫手*/

public class Adapter extends PagerAdapter {

    private List<Model> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public Adapter(List<Model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Nullable
    @Override
    public Object instantiateItem(@Nullable final ViewGroup container, final int position){
        layoutInflater = LayoutInflater.from(context);
        View view =layoutInflater.inflate(R.layout.item,container,false);

        ImageView imageView;
        final TextView title, content;

        imageView = view.findViewById(R.id.image);
        title = view.findViewById(R.id.title);
        content = view.findViewById(R.id.content);

        imageView.setImageResource(models.get(position).getImage());
        title.setText(models.get(position).getTitle());
        content.setText(models.get(position).getContent());


        container.addView(view,0);
        return view;

    }

    @Override
    public void  destroyItem(@Nullable ViewGroup container,int position, @Nullable Object object){
        container.removeView((View)object);
    }


}
