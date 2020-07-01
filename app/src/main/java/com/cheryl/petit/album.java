package com.cheryl.petit;


import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class album extends Fragment implements View.OnClickListener {
    private ImageButton add_photo;
    private CardView add_photocard;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_album, container, false);
        //監聽器
        add_photo = (ImageButton) v.findViewById(R.id.add_photo);
        add_photocard = (CardView) v.findViewById(R.id.add_photocard);
        add_photocard.setOnClickListener(this);


        //加入相簿日記鍵
        add_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(album.this.getContext(),addalbum.class);
                startActivity(intent);
            }
        });

        return v;
    }



    //加入相簿日記鍵(cardview部分)
    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()) {
            case R.id.add_photocard: i = new Intent(view.getContext(), addalbum.class);startActivity(i);break;

        }
    }
}
