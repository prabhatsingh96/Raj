package com.example.prabhat.raj.AppActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.CalendarContract;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.prabhat.raj.R;

import java.util.TimeZone;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission_group.CAMERA;

public class RunTimePermissionActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 200;
    private View view;
    private  boolean enableMap = false;

    public static final int MY_PERMISSIONS_REQUEST_WRITE_CALENDAR = 123;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_run_time_permission);



        context = RunTimePermissionActivity.this;
        Button showCalender = (Button) findViewById(R.id.showCalender);
        showCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if (enableMap){
                   startActivity(new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                           Uri.fromParts("package", getPackageName(), null)));

               }

                //if we do this thing using INTENT then permission is not required
                boolean result = checkPermission();
                if (result) {
                    writeCalendarEvent();
                }
            }
        });
    }
    private void writeCalendarEvent() {

        Toast.makeText(getApplicationContext(), "Your Welcome ", Toast.LENGTH_SHORT).show();
        startActivity (new Intent (this, MapActivity.class));
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)



    public boolean checkPermission()
    {
        int currentAPIVersion = Build.VERSION.SDK_INT;
        if(currentAPIVersion>=android.os.Build.VERSION_CODES.M)
        {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.ACCESS_FINE_LOCATION)) {
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
                    alertBuilder.setCancelable(true);
                    alertBuilder.setTitle("Permission necessary");
                    alertBuilder.setMessage("Get Location permission is necessary to Proceed Further!!!");
                    alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions((Activity)context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_WRITE_CALENDAR);
                        }
                    });
                    AlertDialog alert = alertBuilder.create();
                    alert.show();
                } else {
                    ActivityCompat.requestPermissions((Activity)context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_WRITE_CALENDAR);
                }
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_WRITE_CALENDAR:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    writeCalendarEvent ();
                } else {

                    if (ActivityCompat.shouldShowRequestPermissionRationale (this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                        // Permission dialog was shown for first time
                    } else {

                        if (ActivityCompat.shouldShowRequestPermissionRationale (this, Manifest.permission.SEND_SMS)
                               || ActivityCompat.shouldShowRequestPermissionRationale (this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                            showDialogOK ("SMS and Location Services Permission required for this app",
                                    new DialogInterface.OnClickListener () {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            switch (which) {
                                                case DialogInterface.BUTTON_POSITIVE:
                                                    //
                                                    // checkAndRequestPermissions();
                                                    Toast.makeText (context, "Welcome", Toast.LENGTH_SHORT).show ();
                                                    break;
                                                case DialogInterface.BUTTON_NEGATIVE:
                                                    // proceed with logic by disabling the related features or quit the app.
                                                    break;
                                            }
                                        }
                                    });

                            // No permission dialog shown to user has user has previously checked Never ask again. Here we can show dialog to open setting screen to change permission
                        }
                        else{

                           enableMap = true;
                        }

                    }

                    break;
                }

        }
    }


                private void showDialogOK(String message, DialogInterface.OnClickListener okListener) {
                new AlertDialog.Builder(this)
                        .setMessage(message)
                        .setPositiveButton("OK", okListener)
                        .setNegativeButton("Cancel", okListener)
                        .create()
                        .show();
            }
    }




