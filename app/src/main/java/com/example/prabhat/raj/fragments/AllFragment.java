package com.example.prabhat.raj.fragments;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.prabhat.raj.AppActivity.ImageInLarge;
import com.example.prabhat.raj.R;
import com.example.prabhat.raj.UtilsApp.MyArrayAdapterForBitmap;

import java.util.ArrayList;
import java.util.zip.Inflater;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllFragment extends Fragment {


    private ListView ls;
    private ArrayList<Bitmap> list;
    private ImageInLarge imageInLarge;


    private MyArrayAdapterForBitmap bitmapAdapter;
    public AllFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        imageInLarge = new ImageInLarge();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        list = new ArrayList<Bitmap>();
        View view =  inflater.inflate(R.layout.fragment_all, container, false);


       ls = view.findViewById(R.id.ls_view_image);
        list = getArguments().getParcelableArrayList("list");

        bitmapAdapter = new MyArrayAdapterForBitmap(getContext(),R.layout.single_image_layout,list);
        ls.setAdapter(bitmapAdapter);

        //imgView = view.findViewById(R.id.img);
        // imgView.setVisibility(view.GONE);


        //  LayoutInflater inflater1 = (LayoutInflater) getContext().getSystemService(LAYOUT_INFLATER_SERVICE);
      //  View view1 = inflater.inflate(R.layout.single_image_layout, null);
     //
     //   ArrayAdapter<Bitmap> adpter = new ArrayAdapter<Bitmap>(getContext(), R.layout.single_image_layout,list);
       // imgView.setImageBitmap(list);
     //   ls.setAdapter(adpter);


       /* ArrayAdapter<String> adpter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,list);
        ls.setAdapter(adpter);
       */




       ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


               //imageInLarge.imageInLarge(list.get(i));

               getActivity().startActivity(new Intent(getContext(),ImageInLarge.class).
                       putExtra("image",list.get(i)));

               //     imgView.setImageBitmap(list.get(i));
               // Bitmap bitmap = BitmapFactory.decodeFile(list.get(i));
               // ls.setVisibility(view.GONE);
               // imgView.setVisibility(view.VISIBLE);
               // imgView.setImageBitmap(bitmap);
               // Toast.makeText(getContext(), "your image Path is : :"+list.get(i), Toast.LENGTH_SHORT).show();
            }
       });

        return view;
    }


    public interface SetOnLargeImageListener{
        void imageInLarge(Bitmap img);
    }

}
