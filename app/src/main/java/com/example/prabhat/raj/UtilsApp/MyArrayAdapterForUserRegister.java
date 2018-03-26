package com.example.prabhat.raj.UtilsApp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.provider.MediaStore;

import com.example.prabhat.raj.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by fluper on 21/3/18.
 */

public class MyArrayAdapterForUserRegister extends ArrayAdapter {
    private Context context;
    private ArrayList<UserDetailForRegistration> arrayList;
    public MyArrayAdapterForUserRegister(@Nullable Context context, int resource,
                                         ArrayList<UserDetailForRegistration> arrayList){
        super(context, resource , arrayList);
        this.arrayList=arrayList;
        this.context = context;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        UserDetailForRegistration user = arrayList.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_register_user_layout , parent, false);
       ImageView circleImageView = view.findViewById(R.id.profile_image_c);
        TextView tvName = view.findViewById(R.id.name);

        //set All fields

        tvName.setText(user.getName());
        Picasso.get().load(user.getUri ()).into(circleImageView);

        return view;
    }
}
