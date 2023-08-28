package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class FragmentToActivity extends AppCompatActivity implements FtaFragment.OnFragmentClickListener {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_to_activity);
        FtaFragment fragment = new FtaFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fta_fragment_container,fragment);
        ft.commit();

        tv=findViewById(R.id.fta_tv);
    }

    @Override
    public void onFragmentItemClicked(Name name) {
        tv.setText(name.getName());
    }
}