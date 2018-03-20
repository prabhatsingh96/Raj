package com.example.prabhat.raj.UtilsApp;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prabhat.raj.AppActivity.PopMenuItemActivity;
import com.example.prabhat.raj.R;

import java.util.ArrayList;

/**
 * Created by fluper on 19/2/18.
 */

public class MyRecyclerAdapterForPopUp extends RecyclerView.Adapter<MyRecyclerAdapterForPopUp.MyViewHolderForPopUp> {

    ArrayList<Product> arrayListProduct = new ArrayList<>();
    Context context;
    public MyRecyclerAdapterForPopUp() {
    }

    public MyRecyclerAdapterForPopUp(ArrayList<Product> arrayListProduct, Context context) {
        this.arrayListProduct = arrayListProduct;
        this.context = context;
    }

    @Override
    public MyViewHolderForPopUp onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_row_product,parent,false);
        return new MyViewHolderForPopUp(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolderForPopUp holder, final int position) {

        Product product;
        product = arrayListProduct.get(position);
        holder.tvTitle.setText(product.getTitle());
        holder.tvDescription.setText(product.getDescription());

        holder.tvPopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(context , holder.tvPopUp);
                popupMenu.inflate(R.menu.pop_layout);

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.save:
                                Toast.makeText(context, "data save", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.delete:
                                Toast.makeText(context, "removed", Toast.LENGTH_SHORT).show();
                                arrayListProduct.remove(position);
                                notifyDataSetChanged();
                                break;
                        }

                        return false;
                    }
                });
                popupMenu.show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayListProduct.size();
    }

    public class MyViewHolderForPopUp extends RecyclerView.ViewHolder{

        public TextView tvTitle;
        public TextView tvDescription;
        public TextView tvPopUp;

        public MyViewHolderForPopUp(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDescription = itemView.findViewById(R.id.tv_description);
            tvPopUp = itemView.findViewById(R.id.tv_pop_up);

        }
    }
}
