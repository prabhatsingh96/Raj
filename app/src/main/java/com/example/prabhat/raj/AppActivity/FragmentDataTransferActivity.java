package com.example.prabhat.raj.AppActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.prabhat.raj.R;
import com.example.prabhat.raj.fragments.FragmentOne;
import com.example.prabhat.raj.fragments.FragmentTwo;


import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public class FragmentDataTransferActivity extends AppCompatActivity implements FragmentTwo.OnSetDataListener{

    private EditText etName;
    private Button sendBtn;
    private String value;
    private RelativeLayout rl;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_data_transfer);

        etName = findViewById(R.id.et_user_name);
        sendBtn = findViewById(R.id.send_data);

        transferDataFragToActivity();
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendDataOnFragment();
            }
        });


    }

    private void sendDataOnFragment() {
        FragmentOne frgOne = new FragmentOne();
        Bundle bundle = new Bundle() ;
        String value = etName.getText().toString().trim();
        bundle.putString("userName", value);
        frgOne.setArguments(bundle);

        android.support.v4.app.FragmentManager  fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container_fragment_layout, frgOne);
        ft.commit();

    }

      public void transferDataFragToActivity(){
          FragmentTwo frgTwo = new FragmentTwo();
          android.support.v4.app.FragmentManager  fm = getSupportFragmentManager();
          android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
          ft.add(R.id.container_fragment_layout, frgTwo);
          ft.commit();

      }

    @Override
    public void onSetData(String str) {
        etName.setText(str);
    }
}
