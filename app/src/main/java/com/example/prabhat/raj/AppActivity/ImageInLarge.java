package com.example.prabhat.raj.AppActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.prabhat.raj.R;
import com.example.prabhat.raj.fragments.AllFragment;

public class ImageInLarge extends AppCompatActivity implements AllFragment.SetOnLargeImageListener{

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_in_large);

        imageView = findViewById(R.id.large_image_view);

        Bundle b = new Bundle();
         Intent intent = getIntent();
         b = intent.getExtras();
         Bitmap bitmap = (Bitmap) b.get("image");
          imageView.setImageBitmap(bitmap);
    }

    @Override
    public void imageInLarge(Bitmap img) {
        Log.d("test", " In bitmap");


    }
}
