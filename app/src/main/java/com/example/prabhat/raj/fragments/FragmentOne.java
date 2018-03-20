package com.example.prabhat.raj.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.prabhat.raj.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment {

    private TextView userName;
    public FragmentOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_fragment_one, container, false);

        userName = view.findViewById(R.id.tv_user_data);
        String name = getArguments().getString("userName");
        userName.setText(name);

        return view;
    }

}
