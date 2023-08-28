package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityToFragment extends AppCompatActivity {
    RecyclerView rv;
    TextView tv;
    ArrayList<Name> list;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_fragment);

        rv=findViewById(R.id.rv_atf);
        tv=findViewById(R.id.tv_atf_name);
        list= new ArrayList<>();
        Name n1 = new Name("Ahmed");
        Name n2 = new Name("Mohamed");
        Name n3 = new Name("Ali");
        Name n4 = new Name("Saeed");
        Name n5 = new Name("Aya");

        list.add(n1);
        list.add(n2);
        list.add(n3);
        list.add(n4);
        list.add(n5);

        RvAdapter rvAdapter = new RvAdapter(list, new OnRvItemClickListener() {
            @Override
            public void onItemClick(Name name) {
//                Bundle bundle = new Bundle();
//                bundle.putString("name",name.getName());

//                AtfFragment fragment = new AtfFragment();
//                fragment.setArguments(bundle);

                AtfFragment fragment = AtfFragment.newInstance(name);
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.atf_fragment_container,fragment);
                ft.commit();
            }
        });
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(lm);
        rv.setAdapter(rvAdapter);
    }
}