package com.cheryl.petit;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class permeal extends Fragment {

    private Spinner foodtype;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_permeal, container, false);

       foodtype = v.findViewById(R.id.foodtype);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                v.getContext(), R.layout.custom_spinner,
                getResources().getStringArray(R.array.list8)
        );
        return v;
    }

}
