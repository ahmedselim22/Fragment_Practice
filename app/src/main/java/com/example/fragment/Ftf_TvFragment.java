package com.example.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Ftf_TvFragment extends Fragment {
    String name ;
    public Ftf_TvFragment() {
        // Required empty public constructor
    }

    public static Ftf_TvFragment newInstance(Name name){
        Bundle bundle = new Bundle();
        bundle.putString("name",name.getName());
        Ftf_TvFragment fragment = new Ftf_TvFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle =getArguments();
        if (bundle != null){
            name = bundle.getString("name");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_ftf__tv, container, false);
        TextView tv = v.findViewById(R.id.ftf_fragment_tv);
        tv.setText(name);
        return v;
    }
}