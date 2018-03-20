package com.example.prabhat.raj.AppActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.prabhat.raj.R;

public class SpashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash);
        ProgressDialog prd = new ProgressDialog(this);
        prd.setTitle("Loading");
        prd.setMessage("Please wait");
        prd.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    Intent intentspalsh = new Intent(SpashActivity.this, MainActivity.class);
                    startActivity(intentspalsh);

                    finish();

                }catch(InterruptedException ie){
                 ie.printStackTrace();
                }

            }
        }).start();


    }



    }



