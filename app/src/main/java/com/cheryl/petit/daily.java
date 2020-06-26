package com.cheryl.petit;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;


public class daily extends Fragment {
    private Spinner petname,petbodytype;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_daily, container, false);

        petname = v.findViewById(R.id.petname);
        petbodytype = v.findViewById(R.id.petbodytype);

         ArrayAdapter<String> adapter = new ArrayAdapter<>(
                v.getContext(), R.layout.custom_spinner,
                getResources().getStringArray(R.array.list4)
        );
        return v;


    }

}
