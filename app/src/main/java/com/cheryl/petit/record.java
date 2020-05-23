package com.cheryl.petit;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;


public class record extends Fragment implements View.OnClickListener{
    private CardView cal,doc,supp;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_record,container,false);
       //裝監聽器
        cal =(CardView) v.findViewById(R.id.cal);
        doc =(CardView) v.findViewById(R.id.doc);
        supp =(CardView) v.findViewById(R.id.supp);

        cal.setOnClickListener(this);
        doc.setOnClickListener(this);
        supp.setOnClickListener(this);



        return v;
    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){
            case R.id.cal:i = new Intent(view.getContext(), cal.class);startActivity(i);break;
            case R.id.doc:i = new Intent(view.getContext(), doc.class);startActivity(i);break;
            case R.id.supp:i = new Intent(view.getContext(), supp.class);startActivity(i);break;
            default:break;
        }


    }


}
