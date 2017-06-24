package com.turtledev.pockercounter.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.turtledev.pockercounter.R;
import com.turtledev.pockercounter.RecyclerAdapter.ChargesDictAdapter;
import com.turtledev.pockercounter.objects.Charges;

import java.util.List;
import java.util.Map;

/**
 * Created by 1 on 22.04.2016.
 */
public class ChargeDictFragment extends Fragment implements com.turtledev.pockercounter.Interface.Fragment{
    public static final int  CONT = R.id.contaner;
    public  static  final  int ITEM = R.layout.fcd_item;
    Map<Charges, List<Double>> mapCharges;

    public ChargeDictFragment(Map<Charges, List<Double>> mapCharges) {
        this.mapCharges = mapCharges;
    }




    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_cd_layout,container,false);
        RecyclerView rv=(RecyclerView)view.findViewById(R.id.my_recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        rv.setAdapter(new ChargesDictAdapter(this.mapCharges));

        return view;
    }


    @Override
    public int GetContFragment() {
        return this.CONT;
    }

    @Override
    public int GetItemFragment() {
        return this.ITEM;
    }

    @Override
    public void work() {

    }
}
