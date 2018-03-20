package com.example.prabhat.raj.UtilsApp;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.prabhat.raj.R;

import java.util.ArrayList;

/**
 * Created by fluper on 26/2/18.
 */

public class MyCameraAdapter extends RecyclerView.Adapter<MyCameraAdapter.ViHolder> {


    private ArrayList<Bitmap>  imList;


    public MyCameraAdapter(ArrayList<Bitmap> imList) {
        this.imList = imList;
    }

    @Override
    public ViHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_image_view_layout, parent,false);

        return new ViHolder(view);
    }

    @Override
    public void onBindViewHolder(ViHolder holder, int position) {


        holder.iv.setImageBitmap(imList.get(position));
    }

    @Override
    public int getItemCount() {
        return imList.size();
    }

    class ViHolder extends RecyclerView.ViewHolder{

        public ImageView iv;

        public ViHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_image);


        }
    }
}
