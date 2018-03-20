package com.example.prabhat.raj.AppActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.prabhat.raj.R;
import com.example.prabhat.raj.UtilsApp.DbAdapter;
import com.example.prabhat.raj.UtilsApp.MyArrayAdapter;
import com.example.prabhat.raj.UtilsApp.UserDetail;

import java.util.ArrayList;

public class ShowAllUser extends AppCompatActivity {

    private ArrayList<UserDetail> userDetail;
    private ListView ls;
    private DbAdapter dbAdapter;
    private MyArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_user);

        dbAdapter = new DbAdapter(this);
       // Log.d("TEST", "onCreate");
        ls = findViewById(R.id.list_view);
        userDetail = dbAdapter.showData();
        adapter = new MyArrayAdapter(this,R.layout.single_user_layout,userDetail);
        ls.setAdapter(adapter);

    }
}
