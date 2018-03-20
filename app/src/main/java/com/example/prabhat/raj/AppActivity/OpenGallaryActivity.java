package com.example.prabhat.raj.AppActivity;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.prabhat.raj.UtilsApp.UserDetail;
import com.example.prabhat.raj.UtilsApp.VideoDetail;
import com.example.prabhat.raj.fragments.AllFragment;
import com.example.prabhat.raj.R;
import com.example.prabhat.raj.UtilsApp.TabAdapter;
import com.example.prabhat.raj.fragments.FragmentTwo;
import com.example.prabhat.raj.fragments.ImageFragment;
import com.example.prabhat.raj.fragments.VideoFragment;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public class OpenGallaryActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ImageView humburger;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabAdapter tabAdapter;
    private ArrayList<Bitmap> alist;
    private  ArrayList<String> videoPathList ;
    private ArrayList<String>  imagePathList;
    private AllFragment afg;
    private VideoFragment videoFragment;
    private Bitmap bitmap;
    private FrameLayout fr;
 //   private NavigationView nv;
    //private VideoDetail videoDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_gallary);
        //fr = findViewById(R.id.frame_layout_container);

      // LayoutInflater inflater = LayoutInflater.from(this);
      // View view = inflater.inflate(R.layout.tab_bar_layout,fr, false);


       toolbar = findViewById(R.id.tool_bar);


        setSupportActionBar(toolbar);
        tabLayout =findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        tabAdapter = new TabAdapter(getSupportFragmentManager());
        alist = new ArrayList<Bitmap>();

        alist = getFilePaths();
        afg = new AllFragment();
        Bundle b = new Bundle();
        b.putParcelableArrayList("list", alist);
        afg.setArguments(b);


        videoPathList = getVideoPathFromDcim();
        videoFragment = new VideoFragment();
        b.putStringArrayList("video" , videoPathList);
        videoFragment.setArguments(b);

        imagePathList = getImagesPathFromDcim();
        ImageFragment imgFrngmnt = new ImageFragment();
        b.putStringArrayList("image" , imagePathList);
        imgFrngmnt.setArguments(b);

        tabAdapter.addTab(afg,"All");
        tabAdapter.addTab(imgFrngmnt,"Images");
        tabAdapter.addTab(videoFragment ,"Videos");

        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);

        //navigationDrawer();


    }

    ///navigation Drawer

    public void navigationDrawer(){

     //   dl = findViewById(R.id.drawer_layout);
       // nv = findViewById(R.id.navigation_id);
        //  nv.setVisibility(View.GONE);

        toolbar = findViewById(R.id.tool_bar_include_loayout);
        humburger = toolbar.findViewById(R.id.side_bar_icon);

        ActionBarDrawerToggle abdt = new ActionBarDrawerToggle(this,dl,toolbar, R.string.open, R.string.close);
        dl.addDrawerListener(abdt);


        humburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // nv.setVisibility(View.VISIBLE);
                dl.openDrawer(Gravity.START);

            }
        });

    }


    //get all images

    public ArrayList<String> getImagesPathFromDcim() {


        String path = Environment.getExternalStorageDirectory().toString();

        ArrayList<String> alPath = new ArrayList<String>();
        ArrayList<String> alName = new ArrayList<String>();
        ArrayList<Bitmap> bitmap = new ArrayList<Bitmap>();

        //Bitmap thumb = ThumbnailUtils.createVideoThumbnail(path,
        //      MediaStore.Images.Thumbnails.MINI_KIND);
        //img.setImageBitmap(thumb);



        File directory = new File(path);
        File[] file = directory.listFiles(new FileFilter() {

            @Override
            public boolean accept(File file) {
                return file.getPath().endsWith(".jpg");
            }
        }) ;

        for (int i = 0; i < file.length; i++) {

            alName.add(file[i].getName());
            alPath.add(file[i].getAbsolutePath());
            bitmap.add(ThumbnailUtils.createVideoThumbnail(file[i].getAbsolutePath(),
                    MediaStore.Images.Thumbnails.MINI_KIND));

        }

        //videoDetail = new VideoDetail(alPath,bitmap);


        return alPath;
    }





    /////GET VIDEO FROM DCIM

    public ArrayList<String> getVideoPathFromDcim() {


        String path = Environment.getExternalStorageDirectory().toString();

        ArrayList<String> alPath = new ArrayList<String>();
        ArrayList<String> alName = new ArrayList<String>();
        ArrayList<Bitmap> bitmap = new ArrayList<Bitmap>();

        //Bitmap thumb = ThumbnailUtils.createVideoThumbnail(path,
          //      MediaStore.Images.Thumbnails.MINI_KIND);
         //img.setImageBitmap(thumb);



        File directory = new File(path);
        File[] file = directory.listFiles(new FileFilter() {

            @Override
            public boolean accept(File file) {
                return file.getPath().endsWith(".mp4");
            }
        }) ;

        for (int i = 0; i < file.length; i++) {

            alName.add(file[i].getName());
            alPath.add(file[i].getAbsolutePath());
            bitmap.add(ThumbnailUtils.createVideoThumbnail(file[i].getAbsolutePath(),
                    MediaStore.Images.Thumbnails.MINI_KIND));

        }

       //videoDetail = new VideoDetail(alPath,bitmap);


       return alPath;
    }








/*
     public ArrayList<Bitmap> getFilePaths(){

        ArrayList<Bitmap> btm= new ArrayList<Bitmap>();
        File dcim = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        File[] allImageFile= dcim.listFiles();
        for(File f : allImageFile){
            String singleImagePath = f.getAbsolutePath();
            Bitmap bitmap = BitmapFactory.decodeFile(singleImagePath);
            btm.add(bitmap);

        }
        return btm;
     }

*/

   public ArrayList<Bitmap> getFilePaths()
    {


        Uri u = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String[] projection = {MediaStore.Images.ImageColumns.DATA};
        Cursor c = null;
        SortedSet<String> dirList = new TreeSet<String>();
        ArrayList<Bitmap> resultIAV = new ArrayList<Bitmap>();

        String[] directories = null;
        if (u != null)
        {
            c = managedQuery(u, projection, null, null, null);
        }

        if ((c != null) && (c.moveToFirst()))
        {
            do
            {
                String tempDir = c.getString(0);
                tempDir = tempDir.substring(0, tempDir.lastIndexOf("/"));
                try{
                    dirList.add(tempDir);
                }
                catch(Exception e)
                {

                }
            }
            while (c.moveToNext());
            directories = new String[dirList.size()];
            dirList.toArray(directories);

        }

         for(int i=0;i<dirList.size();i++)
        {
            File imageDir = new File(directories[i]);
            File[] imageList = imageDir.listFiles();
            if(imageList == null)
                continue;
            for (File imagePath : imageList) {
                try {

                    if(imagePath.isDirectory())
                    {
                        imageList = imagePath.listFiles();

                    }
                    if ( imagePath.getName().contains(".jpg")|| imagePath.getName().contains(".JPG")
                            || imagePath.getName().contains(".jpeg")|| imagePath.getName().contains(".JPEG")
                            || imagePath.getName().contains(".png") || imagePath.getName().contains(".PNG")
                            || imagePath.getName().contains(".gif") || imagePath.getName().contains(".GIF")
                            || imagePath.getName().contains(".bmp") || imagePath.getName().contains(".BMP")
                            )
                    {



                        String path= imagePath.getAbsolutePath();

                       BitmapFactory.Options bmOptions = new BitmapFactory.Options();
                        bitmap = BitmapFactory.decodeFile(path,bmOptions);
                        bitmap = Bitmap.createScaledBitmap(bitmap,350,350,true);

                        // Bitmap bitmap = BitmapFactory.decodeFile(path);


                        resultIAV.add(bitmap);

                    }
                }
                //  }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return resultIAV;


    }

}
