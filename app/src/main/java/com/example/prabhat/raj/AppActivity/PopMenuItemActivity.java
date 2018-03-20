package com.example.prabhat.raj.AppActivity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.prabhat.raj.R;
import com.example.prabhat.raj.UtilsApp.MyRecyclerAdapterForPopUp;
import com.example.prabhat.raj.UtilsApp.Product;

import java.util.ArrayList;

public class PopMenuItemActivity extends AppCompatActivity {

    private RecyclerView rvl;
    private Context context;
    private MyRecyclerAdapterForPopUp myRecyclerAdapterForPopUp;
    private Product product;
    private ArrayList<Product> arrayListProduct = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_menu_item);
        rvl = findViewById(R.id.recycler_pop_item);
        productData();
        myRecyclerAdapterForPopUp = new MyRecyclerAdapterForPopUp(arrayListProduct,this);
        rvl.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvl.setAdapter(myRecyclerAdapterForPopUp);

    }

    public void productData(){

        for(int i=0;i<20; i++){
            product = new Product("Title"+i,"description"+i);
            arrayListProduct.add(product);
        }
    }
}
