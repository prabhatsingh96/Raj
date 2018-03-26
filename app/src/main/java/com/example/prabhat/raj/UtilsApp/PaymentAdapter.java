package com.example.prabhat.raj.UtilsApp;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.prabhat.raj.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by fluper on 26/3/18.
 */

public class PaymentAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList<PaymentDetails> arrayList = new ArrayList<> ();
    private TextView cardNumber;
    private TextView months;
    private TextView year;
    private RadioGroup radioGroup;
    private int lastPosition = -1;
    private RadioButton radioButton;


    private RadioButton listRadioButton = null;
    int listIndex = -1;

    public PaymentAdapter(@NonNull Context context, int resource,
                          @NonNull ArrayList<PaymentDetails> arrayList) {
        super (context, resource, arrayList);
        this.context = context;
        this.arrayList = arrayList;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        PaymentDetails paymentDetails = new PaymentDetails ();
        paymentDetails = arrayList.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(R.layout.card_detail_list_layout ,
                parent, false);
        cardNumber = view.findViewById (R.id.et_card_number_list);
        months = view.findViewById (R.id.et_months_list);
        year = view.findViewById (R.id.et_year_list);

        radioButton = view.findViewById (R.id.radio_btn);
        radioButton.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener () {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(radioButton.isChecked ())
                    radioButton.setChecked (false);
                else
                    radioButton.setChecked (true);
            }

        });



        /*radioGroup = view.findViewById (R.id.radio_grp);

        radioGroup.setOnCheckedChangeListener (new RadioGroup.OnCheckedChangeListener () {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                 button = view.findViewById (i);
                button.setOnClickListener (new View.OnClickListener () {
                    @Override
                    public void onClick(View view) {
                        if(button != null){



                               *//* View vMain = ((View) view.getParent());
                                // getParent() must be added 'n' times,
                                // where 'n' is the number of RadioButtons' nested parents
                                // in your case is one.

                                // uncheck previous checked button.
                                if (listRadioButton != null) listRadioButton.setChecked(false);
                                // assign to the variable the new one
                                listRadioButton = (RadioButton) view;
                                // find if the new one is checked or not, and set "listIndex"
                                if (listRadioButton.isChecked ()) {
                                    listIndex = ((ViewGroup) vMain.getParent()).indexOfChild(vMain);
                                } else {
                                    listRadioButton = null;
                                    listIndex = -1;
                                }*//*






                        }
                    }
                });*/

         /*   }
        });
*/
        //set all fields
        cardNumber.setText (paymentDetails.getCardNumber ());
        months.setText (paymentDetails.getMonths ());
        year.setText (paymentDetails.getYear ());




        return view;
    }
}
