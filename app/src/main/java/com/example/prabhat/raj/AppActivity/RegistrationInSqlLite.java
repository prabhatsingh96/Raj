package com.example.prabhat.raj.AppActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prabhat.raj.R;
import com.example.prabhat.raj.UtilsApp.RegistrationDbAdapter;

import java.net.URI;

import de.hdodenhof.circleimageview.CircleImageView;

public class RegistrationInSqlLite extends AppCompatActivity {

    private CircleImageView profileImage;
    private ImageView chooseImage;
    private TextView userName;
    private TextView userAddress;
    private RadioGroup genderRadioGroup;
    private Button submitButton;
    private RegistrationDbAdapter registrationDbAdapter ;
    private Bitmap bitmap;
    private Uri uri;
    private String gender;
    private Intent submitIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_registration_in_sql_lite);
        registrationDbAdapter = new RegistrationDbAdapter (this);
        gettingId ();
         allIntent ();
        allButtonClicksEvents ();
    }

    // getting id
    public void gettingId(){

        profileImage = findViewById (R.id.profile_image);
        chooseImage = findViewById (R.id.choose_image_galary);
        userName = findViewById (R.id.user_name_sql);
        userAddress = findViewById (R.id.user_address_sql);
        genderRadioGroup = findViewById (R.id.rg_gender);
        submitButton = findViewById (R.id.btn_submit);
    }


    //getting all intent
    public void allIntent(){
        submitIntent = new Intent(this, ShowAllRegisterUser.class);

    }

    // All button/Image Clicks Events
    public void allButtonClicksEvents(){

        chooseImage.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                gettingImage ();
            }
        });



        //click on submit button for submit data
        submitButton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                userGender ();
                boolean b = registrationDbAdapter.insertDataInSqlLite (uri.toString (),
                        userName.getText ().toString (),
                        userAddress.getText ().toString ());
                if(b){
                    Toast.makeText (RegistrationInSqlLite.this, "WELCOME"+userName.getText ().toString ()
                            +" You are Registered", Toast.LENGTH_SHORT).show ();
                    submitIntent.putExtra ("name", userName.getText ().toString ());
                    submitIntent.putExtra ("uri", uri.toString ());
                    startActivity (submitIntent);
                }
                else
                    Toast.makeText (RegistrationInSqlLite.this, "Find Some error", Toast.LENGTH_SHORT).show ();
            }
        });
    }


    //finding gender
    public void userGender(){
        genderRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if (null != rb && checkedId > -1) {
                   gender = rb.getText ().toString ().trim ();
                }

            }
        });

    }


    //taking Image from gallary
    public void gettingImage(){

        Intent intentGallery = new Intent();
        intentGallery.setType("image/*");
        intentGallery.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intentGallery.createChooser(intentGallery,
                "Select picture"), 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult (requestCode, resultCode, data);
        try {
            if (requestCode == 100) {
                if (resultCode == Activity.RESULT_OK) {
                    if (data != null) {
                        uri = data.getData ();
                        bitmap = MediaStore.Images.Media.getBitmap (getContentResolver (),
                                uri);

                        profileImage.setImageBitmap (bitmap);

                    }
                }
            }
        } catch (Exception e) {
        }
    }




}
