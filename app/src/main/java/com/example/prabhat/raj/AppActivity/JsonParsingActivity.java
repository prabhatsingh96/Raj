package com.example.prabhat.raj.AppActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prabhat.raj.R;
import com.example.prabhat.raj.UtilsApp.HttpHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonParsingActivity extends AppCompatActivity {


    private String json_string = "{\n    \"message\": \"successfull\",\n    \"result\": {\n        \"user_id\": 8,\n        \"first_name\": \"Doctor\",\n        \"latitude\": \"34.018824699999996\",\n        \"longitude\": \"-118.2857791\",\n        \"device_token\": \"eoFsKtE4zKE:APA91bH9409OkQuTVnOcm_VFAQJbQa5jmUTThqSw_V2KJJ8jolKF0b9mr0JzHLbqIPVoYtuZiKEfXN1Uj9KbP2sRA2cACDA_3u3xgdXAeNX-FOpVcCdBllOT8lfxLG-2yXeiTNnNOnKg\",\n        \"device_type\": 1,\n        \"user_type\": 1,\n        \"last_name\": \"Dre\",\n        \"is_request_student\": 0,\n        \"term_condition\": 1,\n        \"desired_commute\": \"3-8\",\n        \"firebase_id\": \"DGewyqrQSqghqL5DNk3bh7Yep7G2\",\n        \"gender\": null,\n        \"language\": \"Chinese\",\n        \"image\": null,\n        \"professional\": null,\n        \"is_notify\": 1,\n        \"is_bussy\": 0,\n        \"address\": \"3670 Trousdale Pkwy, Los Angeles, CA 90089, USA\",\n        \"rating\": 0\n    }\n}";


    private TextView userId;
    private TextView fName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_json_parsing);
        userId = findViewById (R.id.user_id);
        fName = findViewById (R.id.first_name);
        JSONObject root;
        JSONObject result;

        try {


         root = new JSONObject(json_string);
            Toast.makeText (this, "hello", Toast.LENGTH_SHORT).show ();

         result = new JSONObject(root.getString ("result"));


            userId.setText (root.getString("message"));
            fName.setText (result.getString("first_name"));


    } catch (JSONException e) {
            Toast.makeText (this, ""+e.toString (), Toast.LENGTH_LONG).show ();
            Log.e ("A",""+e);
            e.printStackTrace();
    }


}
}


