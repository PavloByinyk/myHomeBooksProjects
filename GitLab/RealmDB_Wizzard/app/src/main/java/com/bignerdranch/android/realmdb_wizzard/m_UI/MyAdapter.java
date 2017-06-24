package com.bignerdranch.android.realmdb_wizzard.m_UI;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.android.realmdb_wizzard.R;

import java.util.ArrayList;

/**
 * Created by 1 on 20.07.2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context c;
    ArrayList<String> list;

    public MyAdapter(Context c, ArrayList<String> list) {
        this.c = c;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(c).inflate(R.layout.item_model,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.nameText.setText(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
