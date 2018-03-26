package com.example.prabhat.raj.AppActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.prabhat.raj.R;
import com.example.prabhat.raj.UtilsApp.AsynTask;
import com.example.prabhat.raj.UtilsApp.PaymentAdapter;
import com.example.prabhat.raj.UtilsApp.PaymentDetails;
import com.example.prabhat.raj.UtilsApp.PaymentRecyclerAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;

public class PaymentSystemActivity extends AppCompatActivity {


    private String payment;
    private PaymentDetails paymentDetails;
    private ListView cardList;
    private ArrayList<PaymentDetails> arrayList;
    private PaymentRecyclerAdapter adapter;
    private RecyclerView listView;
    private int flag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_payment_system);
        listView = findViewById (R.id.card_list_view);
        arrayList = new ArrayList<> ();
        listView.setVisibility (View.VISIBLE);


    }


    public void addNewCard(View view) {

    startActivityForResult (new Intent (this, CardDetailActivity.class),1);
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult (requestCode, resultCode, data);


            if(requestCode == 1 && data !=null) {

                Gson gson = new Gson ();
               // payment = data.getStringExtra ("payment");
                paymentDetails = gson.fromJson(data.getStringExtra ("payment"),
                        PaymentDetails.class);
                //Log.d ("card","card number"+paymentDetails.getCardNumber ());
                arrayList.add (paymentDetails);

                adapter = new PaymentRecyclerAdapter (this,
                        arrayList);
                listView.setLayoutManager (new LinearLayoutManager (getApplicationContext ()));
                listView.setAdapter (adapter);


            }
            else
                Toast.makeText (this, "data is not found", Toast.LENGTH_SHORT).show ();

    }

    public void proceedBtn(View view) {

        Toast.makeText (this, "your card number is: "+paymentDetails.getCardNumber (), Toast.LENGTH_SHORT).show ();
    }
}
