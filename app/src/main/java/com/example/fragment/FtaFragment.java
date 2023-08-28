package com.example.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FtaFragment extends Fragment {
    OnFragmentClickListener listener;

    public FtaFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_fta, container, false);
        RecyclerView rv=v.findViewById(R.id.rv_fta);

        ArrayList<Name> list= new ArrayList<>();
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
                listener.onFragmentItemClicked(name);
            }
        });

        RecyclerView.LayoutManager lm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(lm);
        rv.setAdapter(rvAdapter);

        return v;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentClickListener){
           listener= (OnFragmentClickListener) context;
        }
        else {
            throw new ClassCastException("Activity doesn't implements interface !!");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }
//    public static FtaFragment newInstance(Name name){
//        Bundle bundle = new Bundle();
//        bundle.putString("name",name.getName());
//        FtaFragment fragment = new FtaFragment();
//        fragment.setArguments(bundle);
//        return fragment;
//    }

    public interface OnFragmentClickListener{
        void onFragmentItemClicked(Name name);
    }
}