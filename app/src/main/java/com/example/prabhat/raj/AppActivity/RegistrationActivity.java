package com.example.prabhat.raj.AppActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.prabhat.raj.R;
import com.example.prabhat.raj.UtilsApp.DbAdapter;
import com.example.prabhat.raj.UtilsApp.MyPreference;
import com.example.prabhat.raj.UtilsApp.UserDetail;
import com.google.gson.Gson;

public class RegistrationActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etContact;
    private  Button btnShowAllUser;
    private Button btnRegister;
    private Button btnShowIntoPage;
    private RelativeLayout rootLayout;
    private  Button btnShowDetail;

    private MyPreference preferences;
    DbAdapter adapter ;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        gettingId();
        adapter = new DbAdapter(this);
        preferences = new MyPreference(this);
    }

    private void gettingId() {
        etName = (EditText) findViewById(R.id.et_name);
        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);
        etContact = (EditText) findViewById(R.id.et_contact);
        btnRegister = (Button) findViewById(R.id.registeration_button);
        rootLayout = (RelativeLayout) findViewById(R.id.root_layout);
        btnShowDetail = (Button) findViewById(R.id.register_data_sql_button);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
        btnShowDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               registerUserInSqliteDataBase();
            }
        });


    }
    // All show all user
    public void showAllUser(View view){

        startActivity(new Intent(this, ShowAllUser.class));
    }

      private void registerUserInSqliteDataBase(){
          String name = etName.getText().toString().trim();
          String email = etEmail.getText().toString().trim();
          String password = etPassword.getText().toString().trim();
          String contact = etContact.getText().toString().trim();
          boolean insertedRow = adapter.insertData(name,email,password,contact);
          if(insertedRow){
              
              Toast.makeText(this, "you are Registerd", Toast.LENGTH_SHORT).show();
              startActivity(new Intent(this, UserInfoActivity.class));
          }
          else
              Toast.makeText(this, "Enable to register", Toast.LENGTH_SHORT).show();

      }



    private void registerUser() {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String contact = etContact.getText().toString().trim();
        int id=0;


        UserDetail user = new UserDetail(id , name, email, password, contact);

        Gson gson = new Gson();
        String jsonString = gson.toJson(user);
        boolean result = preferences.saveString(MyPreference.USER_OBJECT, jsonString);
        if (result) {


            Toast.makeText(this, "Object Saved", Toast.LENGTH_SHORT).show();
            etName.setText("");
            etContact.setText("");
            etPassword.setText("");
            etEmail.setText("");
            Intent intent = new Intent(this, UserInfoActivity.class);
            startActivity(intent);
        } else Toast.makeText(this, "Object Not Saved", Toast.LENGTH_SHORT).show();
    }
    }
































     /* final Snackbar snackbar = Snackbar.make(rootLayout, "Object Saved", Snackbar.LENGTH_INDEFINITE);
            snackbar.setAction("Ok", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Ok Button", Toast.LENGTH_SHORT).show();
                    snackbar.dismiss();
                }
            });
            snackbar.show();
            */
