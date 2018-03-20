package com.example.prabhat.raj.UtilsApp;

import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Created by fluper on 15/2/18.
 */

public class VideoDetail {

   private ArrayList<String> path;
   private ArrayList<Bitmap> thum;

    public VideoDetail(ArrayList<String> path, ArrayList<Bitmap> thum) {
        this.path = path;
        this.thum = thum;
    }

    public ArrayList<String> getPath() {
        return path;
    }

    public void setPath(ArrayList<String> path) {
        this.path = path;
    }

    public ArrayList<Bitmap> getThum() {
        return thum;
    }

    public void setThum(ArrayList<Bitmap> thum) {
        this.thum = thum;
    }
}
