package com.bignerdranch.android.retrofitgsondemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.android.retrofitgsondemo.R;
import com.bignerdranch.android.retrofitgsondemo.model.Flower;
import com.bignerdranch.android.retrofitgsondemo.model.helper.Constants;
import com.squareup.picasso.Picasso;

/**
 * Created by 1 on 23.06.2016.
 */
public class DetailActivity extends AppCompatActivity {

    private TextView name,price,instructions;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        Intent intent=getIntent();

        Flower flower=(Flower) intent.getSerializableExtra(Constants.REFERENCE.FLOWER);

        findViews();

        name.setText(flower.getName().toString());
        price.setText(Double.toString(flower.getPrice()));
        instructions.setText(flower.getInstructions().toString());

        Picasso.with(getApplicationContext()).load("http://services.hanselandpetal.com/photos/"+flower.getPhoto()).into(imageView);



    }

    private void findViews() {
        name=(TextView)findViewById(R.id.textViewname);
        price=(TextView)findViewById(R.id.textView2price);
        instructions=(TextView)findViewById(R.id.instructions);

        imageView=(ImageView)findViewById(R.id.imageView2);
    }
}