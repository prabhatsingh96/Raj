package com.example.prabhat.raj.UtilsApp;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.InputStream;

/**
 * Created by fluper on 22/2/18.
 */

public class AsynTask extends AsyncTask<String, Void,Bitmap> {


    private Context context;
    private GetImage getImagee;
    private ProgressDialog dialog;
    public AsynTask() {
    }



    public AsynTask(Context context,GetImage getImagee) {
        this.context = context;
        this.getImagee = getImagee;
    }




    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = new ProgressDialog(context);
        dialog.setTitle("Downloading Image");
        dialog.setMessage("Downloading...");
        dialog.show();

    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        String uri = strings[0];
        Bitmap bitmap =null;
        try{

            InputStream is = new java.net.URL(uri).openStream();
            bitmap = BitmapFactory.decodeStream(is);
        }catch (Exception e){}
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        dialog.dismiss();
        getImagee.getImage(bitmap);

    }



    public interface GetImage{
         void getImage(Bitmap bitmap);
    }
}
