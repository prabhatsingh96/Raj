package com.example.prabhat.raj.UtilsApp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.prabhat.raj.R;

import java.util.ArrayList;

/**
 * Created by fluper on 26/3/18.
 */


public class PaymentRecyclerAdapter extends RecyclerView.Adapter<PaymentRecyclerAdapter.MyViewHolder> {


    private Context context;
    private ArrayList<PaymentDetails> arrayList = new ArrayList<> ();

    private int lastPosition = -1;



    private RadioButton listRadioButton = null;
    int listIndex = -1;

    public PaymentRecyclerAdapter(Context context, ArrayList<PaymentDetails> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
         View view = inflater.inflate(R.layout.card_detail_list_layout ,
                parent, false);
        return new MyViewHolder (view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        PaymentDetails paymentDetails;
        paymentDetails = arrayList.get(position);
        holder.cardNumber.setText (paymentDetails.getCardNumber ());
        String mask = paymentDetails.getCardNumber ().replaceAll("\\w(?=\\w{4})",
                "*");
        holder.months.setText (paymentDetails.getMonths ());
        holder.year.setText (paymentDetails.getYear ());
        holder.radioButton.setChecked (position == lastPosition);
    }

    @Override
    public int getItemCount() {
        return arrayList.size ();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {


        TextView cardNumber;
        TextView months;
        TextView year;
        RadioGroup radioGroup;
        RadioButton radioButton;

        public MyViewHolder(View itemView) {
            super (itemView);
            cardNumber = itemView.findViewById (R.id.et_card_number_list);
            months = itemView.findViewById (R.id.et_months_list);
            year = itemView.findViewById (R.id.et_year_list);

            radioButton = itemView.findViewById (R.id.radio_btn);
            radioButton.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick(View view) {
                    lastPosition = getAdapterPosition ();
                    notifyDataSetChanged ();
                }
            });

        }

    }
}




/*
    import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class CardDetailActivity extends AppCompatActivity {
    private EditText etCardNumber;
    private Spinner etMonth;
    private Spinner etYear;
    private EditText etCvv;
    private Button btnSaveData;
    public String month[];
    public String year[];
    public String selectedState;
    public String selectedState1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_detail);

        etCardNumber=findViewById(R.id.et_card_number);
        etMonth=findViewById(R.id.et_card_month);
        etYear=findViewById(R.id.et_card_year);
        etCvv=findViewById(R.id.et_Card_cvv);
        btnSaveData=findViewById(R.id.btn_save);
        btnSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });
     showMonth();
     showYear();
    }

    private void showYear() {

        year = getResources().getStringArray(R.array.item_year);
        ArrayAdapter<String> adapterMonths = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, year);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, year);

        etYear.setAdapter(adapter);

        etYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedState1 = year[i];
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

    private void saveData() {
        String cardnumber=etCardNumber.getText().toString().trim();
        String month=selectedState;
        String year=selectedState1;

        Intent dataIntent=getIntent();

        dataIntent.putExtra("CARD_NUMBER",cardnumber);
        dataIntent.putExtra("CARD_MONTH",month);
        dataIntent.putExtra("CARD_YEAR",year);
        setResult(12, dataIntent);
        finish();
    }


}


 */



