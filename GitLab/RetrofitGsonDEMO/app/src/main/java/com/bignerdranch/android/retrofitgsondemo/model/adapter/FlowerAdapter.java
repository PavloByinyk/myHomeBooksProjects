package com.bignerdranch.android.retrofitgsondemo.model.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.android.retrofitgsondemo.R;
import com.bignerdranch.android.retrofitgsondemo.model.Flower;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 23.06.2016.
 */
public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.Holder> {

    private List<Flower> list;
    FlowerOnClickListener flowrOnClick;

    public FlowerAdapter(FlowerOnClickListener onclick) {
        list=new ArrayList<>();
        flowrOnClick=onclick;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_item,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Flower flower=list.get(position);
        holder.bindView(flower);




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addFlower(Flower flower) {
        list.add(flower);
        notifyDataSetChanged();

    }

    public Flower getSelectedFlowerPosition(int position) {
        return list.get(position);
}


    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView imageView;
        private TextView name;
        private TextView price;


        public Holder(View itemView) {
            super(itemView);

            imageView=(ImageView)itemView.findViewById(R.id.imageView);
            name=(TextView)itemView.findViewById(R.id.textView);
            price=(TextView)itemView.findViewById(R.id.textView2);
            itemView.setOnClickListener(this);
        }

        public void bindView(Flower flower) {
            name.setText(flower.getName().toString());
            price.setText("$" + Double.toString(flower.getPrice()));

            if (flower.isFromDatabase()) {
                imageView.setImageBitmap(flower.getPicture());
            } else {
                Picasso.with(itemView.getContext()).load("http://services.hanselandpetal.com/photos/" + flower.getPhoto()).into(imageView);
            }
        }
        @Override
        public void onClick(View v) {
            flowrOnClick.OnClick(getLayoutPosition());

        }
    }

    public interface FlowerOnClickListener{
         void OnClick(int position);
    }
}
