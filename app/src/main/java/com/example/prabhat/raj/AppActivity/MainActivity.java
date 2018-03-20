package com.example.prabhat.raj.AppActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.*;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.prabhat.raj.R;

import com.example.prabhat.raj.UtilsApp.AppUtils;

public class MainActivity extends AppCompatActivity {

    private String name;
    private  String password;
    private EditText editTextOne;
    private EditText editTextTwo;
    private AlertDialog.Builder b;
    private AlertDialog ad;
    private int CAMERA_CONSTANT = 44;
    private int GALLERY_CONSTANT = 45;
    private SharedPreferences preferences;
    private AppUtils utils;
    private SharedPreferences.Editor editor;
    private Intent intent;
    private Intent dataIntent;
    private Button btnGallary;
    private Button dataTranbtn;
    private Button popBtn;
    private Intent popIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextOne = findViewById(R.id.et11);
        editTextTwo = findViewById(R.id.et12);
        btnGallary = findViewById(R.id.gallary_btn);
        dataTranbtn = findViewById(R.id.data_transfer);
        popBtn = findViewById(R.id.btn_pop_menu);
        popIntent = new Intent(this, PopMenuItemActivity.class);

        popBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(popIntent);
            }
        });

        preferences = getSharedPreferences("student", Context.MODE_PRIVATE);
        editor = preferences.edit();
        utils = new AppUtils(this);
        intent = new Intent(this,OpenGallaryActivity.class);
        dataIntent = new Intent(this,FragmentDataTransferActivity.class);
        btnGallary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        dataTranbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(dataIntent);
            }
        });
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 0, 0, "Setting");
        menu.add(0, 1, 1, "Camera");
        menu.add(0, 2, 2, "Gallery");
        menu.add(0, 3, 3, "AllNames");
        menu.add(0, 4, 4, "LogOut");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int iteamId = item.getItemId();
        switch (iteamId) {
            case 0:
                Intent intentSetting = new Intent(Settings.ACTION_SETTINGS);
                startActivity(intentSetting);
                break;
            case 1:
                Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intentCamera, CAMERA_CONSTANT);
                break;
            case 2:
                Intent intentGallery = new Intent();
                intentGallery.setType("image/*");
                intentGallery.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intentGallery.createChooser(intentGallery, "Select picture"), GALLERY_CONSTANT);
                break;
            case 3:
                //Toast.makeText(this, "You are in list View with all names", Toast.LENGTH_SHORT).show();
                Intent intentListView = new Intent(this, ListViewActivity.class);
                startActivity(intentListView);
                break;
            case 4:
                customizeAlertDialog();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if (requestCode == GALLERY_CONSTANT) {
                if (resultCode == Activity.RESULT_OK) {
                    if (data != null) {

                        Uri uri = data.getData();
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                        ImageView iv = (ImageView) findViewById(R.id.iv11);
                       saveDataInSharedPreference("Image",String.valueOf(uri));
                        SharedPreferences preferences = getSharedPreferences("student", Context.MODE_PRIVATE);
                        String mImageUri = preferences.getString("Image", null);
                        iv.setImageURI(Uri.parse(mImageUri));
                        //iv.setImageBitmap(bitmap);

                    }
                }
            } else if (requestCode == CAMERA_CONSTANT) {
                if (resultCode == Activity.RESULT_OK) {
                    if (data != null) {

                        Uri uri1 = data.getData();
                        Bitmap bitmap1 = MediaStore.Images.Media.getBitmap(getContentResolver(), uri1);
                        ImageView iv1 = (ImageView) findViewById(R.id.iv12);
                        iv1.setImageBitmap(bitmap1);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    // customize alert dalog
    public void customizeAlertDialog() {

        b = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.dialog_layout, null);
        b.setView(view);
        // b.show();
        ad = b.create();
        Button btnOk = view.findViewById(R.id.btnok);
        Button btncancel = view.findViewById(R.id.btncancle);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "You are logout", Toast.LENGTH_SHORT).show();
                ad.dismiss();
            }
        });
        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad.dismiss();
                //Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
            }
        });
        ad.show();

    }


    public void btnLogIn(View view) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        name = editTextOne.getText().toString();
        password = editTextTwo.getText().toString();
        // Toast.makeText(this, "name :"+name, Toast.LENGTH_SHORT).show();
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)) {
            ProgressDialog prd = new ProgressDialog(this);
            prd.setTitle("Error");
            prd.setMessage("Please Enter Name & Password");
            prd.show();

        } else if (name.matches(emailPattern) && name.length() > 0 && password.equals("123")) {
            if(saveDataInSharedPreference("Name",name) && saveDataInSharedPreference("Password",password)){
              utils.toast("you are registered ");
           Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);}
            else
                utils.toast("Please register again");


        } else {
            Toast.makeText(this, "Please Enter valid cordinals", Toast.LENGTH_SHORT).show();

        }

    }

    public boolean saveDataInSharedPreference(String key,String value) {


        editor.putString(key, value);
       // editor.putString(key, value);
        boolean com = editor.commit();
        return com;

    }

    //convert bitmap object in string
     public void setImageInSharedPreference(String key, String value){
        preferences = getSharedPreferences("student",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        /* Gson gson = new Gson();
         String json = gson.toJson(preferences);
         editor.putString("ImageObject", json);
         editor.commit();
     */
    }

    public void btnRegistration(View view) {
         Intent intent = new Intent(this, RegistrationActivity.class);
         startActivity(intent);
    }

    public void btnAsynTask(View view) {
         startActivity(new Intent(this, AsynTaskActivity.class));
    }

    public void btnCamera(View view) {

         startActivity(new Intent(this, openCameraActivity.class));
    }
}