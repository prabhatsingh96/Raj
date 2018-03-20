package com.example.prabhat.raj.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.prabhat.raj.R;
import com.example.prabhat.raj.UtilsApp.MyRecyclerAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImageFragment extends Fragment {

    private MyRecyclerAdapter myRecyclerAdapter;
    private RecyclerView rcv;
    private ArrayList<String> videoList;


    public ImageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_image2, container, false);

        rcv = view.findViewById(R.id.recycler_view);
        videoList = new ArrayList<>();
        videoList = getArguments().getStringArrayList("image");


        myRecyclerAdapter = new MyRecyclerAdapter(videoList);
        rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        rcv.setAdapter(myRecyclerAdapter);


        return view;
    }


}
