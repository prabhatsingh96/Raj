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
 * Created by fluper on 27/3/18.
 */

public class parsingArrayAdapter extends ArrayAdapter

{

    private Context context;
    private ArrayList<String> arrayList;
    private TextView userId;
    private TextView firstName;

    public parsingArrayAdapter(@NonNull Context context, int resource, @NonNull ArrayList<String>
            arrayList) {
        super (context, resource, arrayList);
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

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item , parent, false);

        userId = view.findViewById (R.id.user_id);
        firstName = view.findViewById (R.id.first_name);
        userId.setText (arrayList.get (0));
        userId.setText (arrayList.get (1));

        return view;
    }
}




