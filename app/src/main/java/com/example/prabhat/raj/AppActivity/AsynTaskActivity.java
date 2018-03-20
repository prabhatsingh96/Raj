package com.example.prabhat.raj.AppActivity;

import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.prabhat.raj.R;
import com.example.prabhat.raj.UtilsApp.AsynTask;

import de.hdodenhof.circleimageview.CircleImageView;

public class AsynTaskActivity extends AppCompatActivity implements AsynTask.GetImage{

    private String url = "https://marvel-live.freetls.fastly.net/serve/2018/1/87aa953d1fb14cad85e936667df611e0.png?width=320&quality=90&height=568&crop=320:568,offset-y0&fake=.png";
    private String url1 = "http://3.bp.blogspot.com/-adJvyqBwaeg/UoOi0hJbBaI/AAAAAAAAGjE/qO6AG4LgHic/s400/Indian-Cricketer-Sachin-Tendulkar-HD-Wallpapers-2013.jpg";
    private AsynTask task;
    private CircleImageView circleImageView;
    private ImageView im;
    private Button downloadBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asyn_task);

        cancelNotification(this,28);


        circleImageView = findViewById(R.id.asyn_image);
        //im = findViewById(R.id.asyn_image);
        downloadBtn = findViewById(R.id.download_btn);
        task = new AsynTask(this,this);
        downloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                task.execute(url1);
                downloadBtn.setVisibility(View.GONE);
            }
        });


    }

    @Override
    public void getImage(Bitmap bitmap) {
        Log.d("test", String.valueOf(bitmap));
     circleImageView.setImageBitmap(bitmap);
       // im.setImageBitmap(bitmap);
    }


    public static void cancelNotification(Context ctx, int notifyId) {
        String ns = Context.NOTIFICATION_SERVICE;
        NotificationManager nMgr = (NotificationManager) ctx.getSystemService(ns);
        nMgr.cancel(notifyId);
    }
}

