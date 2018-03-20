package com.example.prabhat.raj.AppActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.prabhat.raj.R;
import com.example.prabhat.raj.UtilsApp.DbAdapter;
import com.example.prabhat.raj.UtilsApp.UserDetail;

public class ShowDataByIdActivity extends AppCompatActivity {


    private TextView tvName;
    private TextView tvEmail;
    private TextView tvPassword;
    private TextView tvContact;
    private TextView tvUserInfo;

    DbAdapter dbAdapter;
    UserDetail user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data_by_id);

        dbAdapter = new DbAdapter(this);

        //getting id

        tvName = findViewById(R.id.tv_user_name_id);
        tvName = findViewById(R.id.tv_user_email_id);
        tvName = findViewById(R.id.tv_user_password_id);
        tvName = findViewById(R.id.tv_user_contact_id);
    }
}
