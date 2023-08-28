package com.example.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.NameViewHolder> {

    ArrayList<Name> list;
    OnRvItemClickListener listener;

    public RvAdapter (ArrayList<Name> list ,OnRvItemClickListener listener){
        this.list = list;
        this.listener=listener;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.name_templete,null,false);
        return new NameViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        Name name = list.get(position);
        holder.bind(name);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class NameViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        Name name;
        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(name);
                }
            });
        }
        void bind(Name name){
            this.name = name;
            tv.setText(name.getName());
        }
    }
}
