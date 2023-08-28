package com.example.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FtfFragment extends Fragment {
    RvAdapter adapter;
    ArrayList<Name> list ;
    OnFtfRecyclerViewClickListener listener;
    public FtfFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ftf, container, false);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) RecyclerView rv=v.findViewById(R.id.ftf_rv);

        list = new ArrayList<>();
        Name name1 = new Name("ahmed");
        Name name2 = new Name("mohamed");
        Name name3 = new Name("saeed");
        Name name4 = new Name("ali");
        Name name5 = new Name("aya");
        list.add(name1);
        list.add(name2);
        list.add(name3);
        list.add(name4);
        list.add(name5);

        adapter = new RvAdapter(list, new OnRvItemClickListener() {
            @Override
            public void onItemClick(Name name) {
                listener.onItemClicked(name);
            }
        });
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
        return v;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFtfRecyclerViewClickListener)
            listener = (OnFtfRecyclerViewClickListener) context;
        else
            throw new ClassCastException("Your Activity Doesn't Implements Listener Interface !!");
    }

    public interface OnFtfRecyclerViewClickListener{
        void onItemClicked(Name name);
    }
}