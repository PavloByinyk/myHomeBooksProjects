package com.bignerdranch.android.retrofitgsondemo.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bignerdranch.android.retrofitgsondemo.R;
import com.bignerdranch.android.retrofitgsondemo.controller.RestManager;
import com.bignerdranch.android.retrofitgsondemo.model.Flower;
import com.bignerdranch.android.retrofitgsondemo.model.adapter.FlowerAdapter;
import com.bignerdranch.android.retrofitgsondemo.model.helper.Constants;
import com.bignerdranch.android.retrofitgsondemo.model.helper.FlowerDatabase;
import com.bignerdranch.android.retrofitgsondemo.model.helper.Utils;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements FlowerAdapter.FlowerOnClickListener{
    @Override
    public void OnClick(int position) {
        Flower selectedFlower=mFloweradapte.getSelectedFlowerPosition(position);
        Intent intent=new Intent(MainActivity.this,DetailActivity.class);
        intent.putExtra(Constants.REFERENCE.FLOWER,selectedFlower);
        startActivity(intent);
    }

    private RecyclerView mRecyclerView;
    private RestManager restManager;
    private FlowerAdapter mFloweradapte;
    FlowerDatabase flowerDatabace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configViews();
        restManager=new RestManager();
        flowerDatabace=new FlowerDatabase(this);


        if(Utils.isNetworkAvaliable(getApplicationContext())){
            getFeed();
            Log.d("Log","isNetworkAvaliable true");
        }else {
            getFeedFromDB();
            Log.d("Log","isNetworkAvaliable false");

        }




    }

    private void getFeedFromDB() {
        List<Flower> flowerList=flowerDatabace.getFlowers();

    }

    private void getFeed() {
        Call<List<Flower>> listCall=restManager.getmFlowerService().getAllFlowers();
        listCall.enqueue(new Callback<List<Flower>>() {
            @Override
            public void onResponse(Call<List<Flower>> call, Response<List<Flower>> response) {

                if(response.isSuccessful()){
                    List<Flower> flowerList=response.body();

                    for(int i=0;i<flowerList.size();i++){
                        Flower flower=flowerList.get(i);
                        SaveIntoDatabase saveIntoDatabase=new SaveIntoDatabase();
                        saveIntoDatabase.execute(flower);

                        mFloweradapte.addFlower(flower);

                    }
                }else {

                }
            }

            @Override
            public void onFailure(Call<List<Flower>> call, Throwable t) {

            }
        });
    }

    private void configViews() {
        mRecyclerView=(RecyclerView)findViewById(R.id.recycler_view);
//        mRecyclerView.setHasFixedSize(true);
//        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mFloweradapte= new FlowerAdapter(this);
        mRecyclerView.setAdapter(mFloweradapte);
    }

    public class SaveIntoDatabase extends AsyncTask<Flower,Flower,Boolean>{

        @Override
        protected Boolean doInBackground(Flower... params) {

            Flower flower=params[0];

            try{
                InputStream inputStream=new URL("http://services.hanselandpetal.com/photos/"+flower.getPhoto()).openStream();
                Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
                flower.setPicture(bitmap);
                publishProgress(flower);

            }catch (Exception e){

            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Flower... values) {
            super.onProgressUpdate(values);
            flowerDatabace.addFlower(values[0]);
        }
    }
}
