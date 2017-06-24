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
 * Created by 1 on 22.04.2016.
 */
public class ChargesDictAdapter extends RecyclerView.Adapter<ChargesDictAdapter.ChargesViewHolder> {

    Map<Charges, List<Double>> data;
    private Set<Map.Entry<Charges, List<Double>>> entrySet;



    public ChargesDictAdapter(Map<Charges, List<Double>> data){

        this.data = data;
        entrySet = data.entrySet();
    }


    @Override
    public ChargesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fcd_item, parent, false);
        ChargesViewHolder chargesViewHolder=new ChargesViewHolder(view);
        return chargesViewHolder;
    }

    @Override
    public void onBindViewHolder(ChargesViewHolder holder, int position) {

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

    public class ChargesViewHolder extends RecyclerView.ViewHolder {
        TextView chargesItem;
        LinearLayout ll;

        public ChargesViewHolder(View itemView) {
            super(itemView);
            ll=(LinearLayout)itemView.findViewById(R.id.fcd_item_ll);
            chargesItem = (TextView)itemView.findViewById(R.id.fcd_item);
        }
    }
}
