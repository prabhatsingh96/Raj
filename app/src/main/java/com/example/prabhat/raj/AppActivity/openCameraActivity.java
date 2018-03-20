package com.example.prabhat.raj.AppActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.prabhat.raj.R;
import com.example.prabhat.raj.UtilsApp.MyCameraAdapter;

import java.util.ArrayList;

public class openCameraActivity extends AppCompatActivity {

    RecyclerView rv;
    private MyCameraAdapter adapter;
    ArrayList<Bitmap>  bitmaps;
    int CAMERA_CONSTANTT = 12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_camera);
        rv = findViewById(R.id.rv_camera);
        bitmaps = new ArrayList<>();
    }


    @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if (requestCode == CAMERA_CONSTANTT) {
                if (resultCode == Activity.RESULT_OK) {
                    if (data != null) {


                        Bitmap btm = (Bitmap) data.getExtras().get("data");
                        bitmaps.add(btm);
                        adapter = new MyCameraAdapter(bitmaps);
                        rv.setLayoutManager(new LinearLayoutManager(this));
                        rv.setAdapter(adapter);
                        rv.getAdapter().notifyDataSetChanged();
                    }
                }
            }
                    }catch (Exception e){}

        }

    public void openCamera(View view) {

        Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intentCamera, CAMERA_CONSTANTT);

    }
}
