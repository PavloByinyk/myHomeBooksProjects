package com.turtledev.a1_asynktasck;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    MyTask mt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo=(TextView)findViewById(R.id.tvInfo);
    }

    public void onclick(View v) {
        mt = new MyTask();
        mt.execute("file_path_1", "file_path_2", "file_path_3", "file_path_4");
    }


    public class MyTask extends AsyncTask<String,String,Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tvInfo.setText("Begin");
        }

        @Override
        protected Void doInBackground(String... urls) {
            int count=0;

            for(String url: urls){
// загружаем файл
                try {
                    downloadFiles();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // выводим промежуточные результаты
                publishProgress(url);
            }
            // разъединяемся
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);

            tvInfo.setText("Downloaded " + values[0].toString() + " file");
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            tvInfo.setText("End");
        }

        public void downloadFiles() throws InterruptedException {
            TimeUnit.SECONDS.sleep(2);
        }
    }
}
