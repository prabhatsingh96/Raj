package com.example.prabhat.raj.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.prabhat.raj.AppActivity.ImageInLarge;
import com.example.prabhat.raj.AppActivity.VideoActivity;
import com.example.prabhat.raj.R;
import com.example.prabhat.raj.UtilsApp.MyRecyclerAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment {

    private ListView videoListView ;
    private ArrayAdapter adapter;
    //private MyRecyclerAdapter myRecyclerAdapter;
   // private RecyclerView rcv;
    private ArrayList<String> videoList;

    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_video, container, false);

        videoListView = view.findViewById(R.id.video_list_view);
       // rcv = view.findViewById(R.id.recycler_view);
        videoList = new ArrayList<>();
        videoList = getArguments().getStringArrayList("video");

        adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,videoList);
        videoListView.setAdapter(adapter);


       videoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



           getActivity().startActivity(new Intent(getContext(), VideoActivity.class).
                      putExtra("video",videoList.get(i)));

            }
       });


//        myRecyclerAdapter = new MyRecyclerAdapter(videoList);
//        rcv.setLayoutManager(new LinearLayoutManager(getContext()));
//        rcv.setAdapter(myRecyclerAdapter);
//






        return view;
    }

}
