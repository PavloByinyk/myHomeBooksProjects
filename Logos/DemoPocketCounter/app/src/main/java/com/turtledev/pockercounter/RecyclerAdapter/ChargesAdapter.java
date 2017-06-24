package com.turtledev.pockercounter.RecyclerAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.turtledev.pockercounter.R;
import com.turtledev.pockercounter.objects.Charges;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by 1 on 26.04.2016.
 */
public class ChargesAdapter extends RecyclerView.Adapter<ChargesAdapter.ChargessViewHolder> {

    Map<Charges, List<Double>> data;
    private Set<Map.Entry<Charges, List<Double>>> entrySet;



    public ChargesAdapter(Map<Charges, List<Double>> data){

        this.data = data;
        entrySet = data.entrySet();
    }


    @Override
    public ChargessViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_c_layout, parent, false);
        ChargessViewHolder chargessViewHolder=new ChargessViewHolder(view);
        return chargessViewHolder;
    }

    @Override
    public void onBindViewHolder(ChargessViewHolder holder, int position) {

        int i = 0;
        for (Map.Entry<Charges, List<Double>> entry : entrySet) {
            if (i == position) {
                holder.chargesItem.setText(entry.getKey().getName().toString());


            }
            i++;
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ChargessViewHolder extends RecyclerView.ViewHolder {
        TextView chargesItem;
        LinearLayout ll;

        public ChargessViewHolder(View itemView) {
            super(itemView);
            ll=(LinearLayout)itemView.findViewById(R.id.tv_total);
            chargesItem = (TextView)itemView.findViewById(R.id.fcd_item);
        }
    }
}
