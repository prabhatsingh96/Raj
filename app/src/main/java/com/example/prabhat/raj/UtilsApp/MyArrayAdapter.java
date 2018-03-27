package com.example.prabhat.raj.UtilsApp;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.prabhat.raj.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by fluper on 8/2/18.
 */

public class MyArrayAdapter extends ArrayAdapter {

    private Context context;
    private ArrayList<UserDetail> arrayList;
    public MyArrayAdapter(@NonNull Context context, int resource, ArrayList<UserDetail> arrayList){
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

        UserDetail user = arrayList.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_user_layout , parent, false);
        CircleImageView circleImageView = view.findViewById(R.id.circular_image);
        TextView tvName = view.findViewById(R.id.lv_name);
        TextView tvContact = view.findViewById(R.id.lv_contact);
        TextView tvEmail = view.findViewById(R.id.lv_email);

        //set All fields

        tvName.setText(user.getName());
        tvContact.setText(user.getContact());
        tvEmail.setText(user.getEmail());
        circleImageView.setImageDrawable(context.getDrawable(R.drawable.profile));
        return view;
    }
}


