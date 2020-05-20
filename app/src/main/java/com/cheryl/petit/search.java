package com.cheryl.petit;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;


public class search extends Fragment implements  View.OnClickListener{
    private CardView park,place,hospital,salon,hotel,restaurant;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_search, container, false);
        //裝監聽器
        park =(CardView) v.findViewById(R.id.park);
        place =(CardView) v.findViewById(R.id.place);
        hospital =(CardView) v.findViewById(R.id.hospital);
        salon =(CardView) v.findViewById(R.id.salon);
        hotel =(CardView) v.findViewById(R.id.hotel);
        restaurant =(CardView) v.findViewById(R.id.restaurant);

        park.setOnClickListener(this);
        place.setOnClickListener(this);
        hospital.setOnClickListener(this);
        salon.setOnClickListener(this);
        hotel.setOnClickListener(this);
        restaurant.setOnClickListener(this);

        return v;
    }

    public void onClick(View view) {
        Intent i;

        switch (view.getId()){
            case R.id.park:i = new Intent(view.getContext(), park.class);startActivity(i);break;
            case R.id.place:i = new Intent(view.getContext(), place.class);startActivity(i);break;
            case R.id.hospital:i = new Intent(view.getContext(), hospital.class);startActivity(i);break;
            case R.id.hotel:i = new Intent(view.getContext(), hotel.class);startActivity(i);break;
            case R.id.restaurant:i = new Intent(view.getContext(), restaurant.class);startActivity(i);break;
            case R.id.salon:i = new Intent(view.getContext(), salon.class);startActivity(i);break;
            default:break;
        }

    }
}
