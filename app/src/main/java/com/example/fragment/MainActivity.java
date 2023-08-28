package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    Button first , second;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first = findViewById(R.id.btn_first);
        second = findViewById(R.id.btn_second);

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager= getSupportFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                FirstFragment ff = new FirstFragment();
                ft.replace(R.id.fragment_container,ff);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager= getSupportFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                SecondFragment sf = new SecondFragment();
                ft.replace(R.id.fragment_container,sf);
                ft.addToBackStack(null);
                ft.commit();
            }
        });


    }
}