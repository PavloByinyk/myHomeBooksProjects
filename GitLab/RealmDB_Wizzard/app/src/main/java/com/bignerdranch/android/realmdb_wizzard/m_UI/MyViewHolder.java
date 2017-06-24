package com.bignerdranch.android.realmdb_wizzard.m_UI;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bignerdranch.android.realmdb_wizzard.R;

/**
 * Created by 1 on 20.07.2016.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView nameText;

    public MyViewHolder(View itemView) {
        super(itemView);

        nameText= (TextView) itemView.findViewById(R.id.nameText);

    }
}
