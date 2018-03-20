package com.example.prabhat.raj.AppActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.prabhat.raj.R;

import java.util.ArrayList;

public class VideoActivity extends AppCompatActivity {

    private VideoView videoView;
    private ArrayList<String> videoArrayList;
    String videoPath;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView = findViewById(R.id.open_video);
        img = findViewById(R.id.img_view);
        Bundle b = getIntent().getExtras();

         videoPath = (String) b.get("video");
//        Bitmap thumb = ThumbnailUtils.createVideoThumbnail(videoPath,
//                MediaStore.Images.Thumbnails.MINI_KIND);
//        img.setImageBitmap(thumb);

         playVideo();

      // videoView.setVideoPath(videoPath);

    }



    public void playVideo(){
        MediaController videoMediaController;

        VideoView mVideoView  = findViewById(R.id.open_video);
        videoMediaController = new MediaController(this);
        mVideoView.setVideoPath(videoPath);
        videoMediaController.setMediaPlayer(mVideoView);
        mVideoView.setMediaController(videoMediaController);
        mVideoView.requestFocus();
        mVideoView.start();
    }
}
