package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class FragmentToFragment extends AppCompatActivity implements FtfFragment.OnFtfRecyclerViewClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_to_fragment);
    }

    @Override
    public void onItemClicked(Name name) {
        Ftf_TvFragment fragment = Ftf_TvFragment.newInstance(name);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.ftf_tv_container,fragment);
        ft.commit();
    }
}