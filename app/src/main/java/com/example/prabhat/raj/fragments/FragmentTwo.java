package com.example.prabhat.raj.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.prabhat.raj.AppActivity.FragmentDataTransferActivity;
import com.example.prabhat.raj.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTwo extends Fragment {

    private String email="prbt@123";
    private FragmentDataTransferActivity fdta;
    public FragmentTwo() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        fdta = (FragmentDataTransferActivity)context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fdta.onSetData(email);
        return inflater.inflate(R.layout.fragment_fragment_two, container, false);
    }

    public interface OnSetDataListener{
        public void onSetData(String str);
    }

}
