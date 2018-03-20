package com.example.prabhat.raj.UtilsApp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by fluper on 23/2/18.
 */

public class MyBroadCastReciever extends BroadcastReceiver {
    public MyBroadCastReciever() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean chargingStatus = false;
        String action = intent.getAction();
        if(action.equals(intent.ACTION_POWER_CONNECTED)){
            chargingStatus = true;
        }
        else if(action.equals(Intent.ACTION_POWER_DISCONNECTED)){
            chargingStatus = false;
        }

        //start service

        Intent serviceIntent = new Intent(context,ChargingServices.class);
        serviceIntent.putExtra("STATUS",chargingStatus);
        context.startService(serviceIntent);
    }
}
