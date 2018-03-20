package com.example.prabhat.raj.UtilsApp;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.prabhat.raj.R;

import java.util.ArrayList;

/**
 * Created by fluper on 13/2/18.
 */

public class MyArrayAdapterForBitmap extends ArrayAdapter<Bitmap> {

    private Context context;
    private ArrayList<Bitmap> arrayList;

    public MyArrayAdapterForBitmap(@NonNull Context context, int resource, ArrayList<Bitmap> bitmapArrayList) {
        super(context, resource, bitmapArrayList);
        this.arrayList = bitmapArrayList;
        this.context = context;
    }


    @Nullable
    @Override
    public Bitmap getItem(int position) {
        return arrayList.get(position);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Bitmap bitmap = arrayList.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_image_layout, parent, false);
        ImageView imageView = view.findViewById(R.id.circular_image);

        imageView.setImageBitmap(bitmap);

        return view;
    }
}