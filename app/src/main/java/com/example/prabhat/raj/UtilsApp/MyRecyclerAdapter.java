package com.example.prabhat.raj.UtilsApp;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prabhat.raj.R;

import java.util.ArrayList;

/**
 * Created by fluper on 15/2/18.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {



    private ArrayList<String> arrayList;

    public MyRecyclerAdapter(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_row_recycler_view,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.et.setText(arrayList.get(position).toString());
       // ArrayList<Bitmap> bitmap=videoDetail.getThum().get(position);
       // holder.rv.setImageBitmap();

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

      //  public ImageView rv;
        public TextView et;

     public MyViewHolder(View itemView) {
         super(itemView);

       //  rv = itemView.findViewById(R.id.img_cicular_video_thumnail);
         et = itemView.findViewById(R.id.et_video_path);
     }
 }
}
