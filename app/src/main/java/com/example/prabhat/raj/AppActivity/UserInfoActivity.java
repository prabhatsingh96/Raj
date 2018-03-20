package com.example.prabhat.raj.AppActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prabhat.raj.R;
import com.example.prabhat.raj.UtilsApp.DbAdapter;
import com.example.prabhat.raj.UtilsApp.MyPreference;
import com.example.prabhat.raj.UtilsApp.UserDetail;
import com.google.gson.Gson;

public class UserInfoActivity extends AppCompatActivity {
    private EditText etId;
    private TextView tvName;
    private TextView tvEmail;
    private TextView tvPassword;
    private TextView tvContact;
    private TextView tvUserInfo;

    private Button btnShowSqliteData;
    private Button btnShowInfo;
    DbAdapter adpter;
    private MyPreference preferences;
    UserDetail user ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        preferences = new MyPreference(this);
        adpter = new DbAdapter(this);

        etId = findViewById(R.id.et_id);
        tvUserInfo = (TextView) findViewById(R.id.tv_user_info);
        tvName = (TextView) findViewById(R.id.tv_user_name);
        tvEmail = (TextView) findViewById(R.id.tv_user_email);
        tvPassword = (TextView) findViewById(R.id.tv_user_password);
        tvContact = (TextView) findViewById(R.id.tv_user_contact);
        btnShowInfo = (Button) findViewById(R.id.btn_show_user_info);
        btnShowSqliteData = findViewById(R.id.btn_show_user_info_from_sqlite);
        btnShowInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showUserInfo();
            }
        });
        btnShowSqliteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // showUserInfoFromSqliteDataBase();
            }
        });

        etId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               String userId = etId.getText().toString().trim();
                if (!TextUtils.isEmpty(userId)) {
                    int id = Integer.parseInt(userId);
                    user = adpter.showUserDetailById(id);

                    if (user != null) {
                        tvName.setText(user.getName());

                        tvEmail.setText(user.getEmail());

                        tvPassword.setText(user.getPassword());

                        tvContact.setText(user.getContact());
                    }
                    else {
                        Toast.makeText(UserInfoActivity.this, "User Not Found", Toast.LENGTH_SHORT).show();
                        Log.d("TEST", "No User Found");

                        tvName.setText("");
                        tvPassword.setText("");
                        tvEmail.setText("");
                        tvContact.setText("");

                    }
                }


            }

            @Override

            public void afterTextChanged(Editable editable) {


                /*tvName.setText("");

                tvEmail.setText("");

                tvPassword.setText("");

                tvContact.setText(""); */
            }
        });
    }



  /*  private void showUserInfoFromSqliteDataBase() {
        user = adpter.showData();
        if (user != null) {
            tvName.setText(user.getName());
           // Log.d("TAG",user.getName());
            tvEmail.setText(user.getEmail());
            //Log.d("TAG",user.getEmail());
            tvPassword.setText(user.getPassword());
           // Log.d("TAG",user.getPassword());
            tvContact.setText(user.getContact());
        }
        else
            Toast.makeText(this, "Some Error !", Toast.LENGTH_SHORT).show();


    */

    private void showUserInfo() {
        String jsonString = preferences.getString(MyPreference.USER_OBJECT);
        Gson gson = new Gson();
        UserDetail user = gson.fromJson(jsonString, UserDetail.class);
        tvUserInfo.setVisibility(View.VISIBLE);
        tvName.setText(user.getName());
        tvEmail.setText(user.getEmail());
        tvPassword.setText(user.getPassword());

        tvContact.setText(user.getContact());
    }
    }

