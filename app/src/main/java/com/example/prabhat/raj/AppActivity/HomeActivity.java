package com.example.prabhat.raj.AppActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.prabhat.raj.R;
import com.example.prabhat.raj.UtilsApp.AppUtils;

import java.util.Calendar;

public class HomeActivity extends AppCompatActivity {

    private RadioButton maleRadioBtn;
    private RadioButton femaleRadioBtn;
    private int date;
    private int month;
    private int year;
    private int hour;
    private int minute;
    private TextView textView;
    private TextView textViewTime;
    String state[];
    Spinner spinnerState;
    String selectedState;
    Button btnDisplay;
    ImageView mImage;
    AppUtils utils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
         utils = new AppUtils(this);
        maleRadioBtn = findViewById(R.id.radio_button_male);
        femaleRadioBtn = findViewById(R.id.radio_button_female);
        textView = findViewById(R.id.text);
        textViewTime = findViewById(R.id.text_time);
        state = getResources().getStringArray(R.array.state_list);
        spinnerState = findViewById(R.id.spinner_state);
       // mImage = findViewById(R.id.iv_image);
        //btnDisplay =  findViewById(R.id.display_button);
       // stateSpinner();
    }
    //spinner
    public void stateSpinner(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,state);
        spinnerState.setAdapter(adapter);

        spinnerState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedState=state[i];
               // Toast.makeText(HomeActivity.this, ""+selectedState, Toast.LENGTH_SHORT).show();
                utils.toast(selectedState);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void SpinnerSubmitbtn(View view){
        stateSpinner();
    }
    public void calendarText(View view) {
        datePicker();
    }
    public void timeText(View view){
        timePicker();
    }

    public void timePicker(){
        Calendar calender = Calendar.getInstance();
        hour = calender.get(Calendar.HOUR);
        minute = calender.get(Calendar.MINUTE);
        TimePickerDialog timepicker = new TimePickerDialog(this,new MyTimePickerListener(), hour,minute,true);
        timepicker.show();
    }

    //date picker
    public void datePicker() {
        Calendar calender = Calendar.getInstance();
        date = calender.get(Calendar.DATE);
        month = calender.get(Calendar.MINUTE);
        year = calender.get(Calendar.YEAR);
        hour = calender.get(Calendar.HOUR);
        minute = calender.get(Calendar.MINUTE);
        //make date picker
        DatePickerDialog datepicker = new DatePickerDialog(this, new MyDatepickerListener(), year, month, date);
        datepicker.show();



    }

    public void btnDisplay(View view) {

        SharedPreferences preferences = getSharedPreferences("student", Context.MODE_PRIVATE);
        String email = preferences.getString("Name","data not found");
        String pass = preferences.getString("Password","data not found");
        Toast.makeText(this, email+"&"+pass , Toast.LENGTH_SHORT).show();
    }

    //my time picker listener
    class  MyTimePickerListener implements TimePickerDialog.OnTimeSetListener{

        @Override
        public void onTimeSet(TimePicker timePicker,int hour,int minute){
            String selectedtime = hour+":"+minute;
            textViewTime.setText(selectedtime);
        }
    }

  //  mydate picker listener
    class MyDatepickerListener implements DatePickerDialog.OnDateSetListener{

        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int date) {
            String selectDate = year+"/"+month+"/"+date;
            textView.setText(selectDate);
        }
    }

}

