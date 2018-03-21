package com.example.prabhat.raj.AppActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.prabhat.raj.R;
import com.example.prabhat.raj.UtilsApp.MyArrayAdapterForUserRegister;
import com.example.prabhat.raj.UtilsApp.RegistrationDbAdapter;
import com.example.prabhat.raj.UtilsApp.UserDetailForRegistration;

import java.util.ArrayList;

public class ShowAllRegisterUser extends AppCompatActivity {

    private ListView listViewUser;
    private ArrayList<UserDetailForRegistration> arrayList;
    private UserDetailForRegistration user;
    private RegistrationDbAdapter userRegistrationData;// =  new RegistrationDbAdapter (this);
    private MyArrayAdapterForUserRegister myArrayAdapterForUserRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_show_all_register_user);
        listViewUser = findViewById (R.id.list_register_user);

        userRegistrationData = new RegistrationDbAdapter (this);
        arrayList = userRegistrationData.showData ();

        myArrayAdapterForUserRegister = new MyArrayAdapterForUserRegister (this,
                R.layout.single_register_user_layout, arrayList);


        listViewUser.setAdapter (myArrayAdapterForUserRegister);
        listViewUser.setOnItemClickListener (new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity (new Intent (getApplicationContext (), RegistrationInSqlLite.class));
            }
        });
    }
}




 /* String name = getIntent ().getExtras ().getString ("name");
        String uri = getIntent ().getExtras ().getString ("uri");
        user.setName (name);
        user.setUri (uri);
        arrayList.add(user);*/