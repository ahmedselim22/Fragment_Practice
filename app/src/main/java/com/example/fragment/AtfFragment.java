package com.example.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AtfFragment extends Fragment {
    private String name;

    public AtfFragment() {
        // Required empty public constructor
    }

    public static AtfFragment newInstance(Name name){
        Bundle bundle = new Bundle();
        bundle.putString("name",name.getName());
        AtfFragment fragment = new AtfFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            name = bundle.getString("name");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_atf, container, false);
        TextView tv=v.findViewById(R.id.atf_fragment_tv);
        tv.setText(name);
        return v;
    }
}