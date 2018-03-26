package com.example.prabhat.raj.UtilsApp;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.prabhat.raj.R;

/**
 * Created by prabhat on 3/2/18.
 */

public class AppUtils {
    Context context;
    public AppUtils(Context context) {
        this.context = context;
    }
      /*  public void toast(String massage)
        {
            Toast.makeText(context,massage,Toast.LENGTH_LONG).show();
        }*/
        public void toast(String massage){

          Toast toast = new Toast(context);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view =  inflater.inflate(R.layout.custom_toast,null);
            toast.setView(view);
            toast.setGravity(Gravity.CENTER_HORIZONTAL,0,100);
            //toast.setText(massage);
            //toast.show();
        }





    }


