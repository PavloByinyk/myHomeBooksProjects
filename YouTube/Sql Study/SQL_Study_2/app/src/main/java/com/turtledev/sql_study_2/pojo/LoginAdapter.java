package com.turtledev.sql_study_2.pojo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.turtledev.sql_study_2.R;

import java.util.ArrayList;

/**
 * Created by 1 on 27.05.2016.
 */
public class LoginAdapter extends BaseAdapter {

    ArrayList<Login> loginList;
    Context context;
    LayoutInflater lInflater;

    public LoginAdapter(ArrayList<Login> loginList, Context context) {
        this.loginList = loginList;
        this.context = context;
        lInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }




    @Override
    public int getCount() {
        return loginList.size();
    }

    @Override
    public Object getItem(int position) {
        return loginList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.login_item, parent, false);
        }

        Login l = getLogin(position);

        ((TextView) view.findViewById(R.id.textView)).setText(l.getName().toString());
        ((TextView) view.findViewById(R.id.textView2)).setText(l.getPassword().toString());
        ((TextView) view.findViewById(R.id.button)).setText(String.valueOf(l.getId()));





        return view;
    }
    Login getLogin(int position) {
        return ((Login) getItem(position));
    }

}
