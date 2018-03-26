package com.example.prabhat.raj.AppActivity;

import android.content.Intent;
import android.opengl.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.prabhat.raj.R;
import com.example.prabhat.raj.UtilsApp.PaymentDetails;
import com.google.gson.Gson;

import java.io.Serializable;

public class CardDetailActivity extends AppCompatActivity {

    private EditText cardNumber;
    private EditText months;
    private EditText year;
    private EditText cvvNumber;
    private PaymentDetails paymentDetails;



    private Spinner etMonth;
    private Spinner etYear;
    public String month[];
    public String years[];
    public String selectedState;
    public String selectedState1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_card_detail);
        gettingId ();
       // gettingDataFromLayout ();
    }

    //getting All id
    public void gettingId(){

        cardNumber = findViewById (R.id.et_card_number);
        etMonth = findViewById (R.id.et_months);
        etYear = findViewById (R.id.et_year);
        cvvNumber = findViewById (R.id.et_cvv);
        showMonth ();
        showYear ();
    }

    //getting data from layout
    public void gettingDataFromLayout(){

        String cNumber = cardNumber.getText ().toString ().trim ();
       //// String cMonths = etMonth.getText ().toString ().trim ();
       // String cYear   = etYear.getText ().toString ().trim ();
        String cCvv    = cvvNumber.getText ().toString ().trim ();


/* Intent intent = new Intent (this,PaymentSystemActivity.class);
        intent.putExtra ("card",cNumber);
        intent.putExtra ("month",cMonths);
        intent.putExtra ("year",cYear);
      //  intent.putExtra ("flag", 1);
        startActivity (intent);*/
        paymentDetails = new PaymentDetails (cNumber,selectedState,selectedState1);
    }

    public void saveData(View view) {


        gettingDataFromLayout ();
        Intent sIntent = getIntent ();
        Gson gson = new Gson ();
        String myJson = gson.toJson(paymentDetails);
        sIntent.putExtra("payment", myJson);


        setResult(1, sIntent);
        finish ();
        //startActivity (saveIntent);
    }



    private void showYear() {

        years = getResources().getStringArray(R.array.item_year);
        ArrayAdapter<String> adapterMonths = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, years);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, years);

        etYear.setAdapter(adapter);

        etYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedState1 = years[i];
                Log.d("Test", "selectedState=" + selectedState);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });


    }

    private void showMonth() {
        month = getResources().getStringArray(R.array.item_month);
        ArrayAdapter<String> adapterMonths = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, month);
        etMonth.setAdapter(adapterMonths);


        etMonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedState = month[i];
                Log.d("Test", "selectedState=" + selectedState);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });



    }


}
