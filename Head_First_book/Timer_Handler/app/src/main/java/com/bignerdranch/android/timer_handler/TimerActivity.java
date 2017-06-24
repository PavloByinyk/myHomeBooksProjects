package com.bignerdranch.android.timer_handler;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {

    private int seconds = 0;
    private boolean running;

    Button start,stop,reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);


        start=(Button) findViewById(R.id.Start);
        stop=(Button) findViewById(R.id.Stop);
        reset=(Button) findViewById(R.id.Reset);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickStart(v);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickStop(v);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickReset(v);
            }
        });

        runTimer();
//        Intent intent=new Intent(Intent.ACTION_SEND);
//        intent.setType("text/plain");
//        intent.putExtra(Intent.EXTRA_TEXT,"Yo-ho-ho!");
//
//        Intent setChosen=Intent.createChooser(intent," set Chosen, please");
//        startActivity(setChosen);
    }


    //Запустить секундомер при щелчке на кнопке Start.
    public void onClickStart(View view) {
        running = true;
    }

    //Остановить секундомер при щелчке на кнопке Stop.
    public void onClickStop(View view) {
        running = false;
    }

    //Обнулить секундомер при щелчке на кнопке Reset.
    public void onClickReset(View view) {
        running = false;
        seconds = 0;
    }


    private void runTimer() {
        final TextView timeView = (TextView)findViewById(R.id.tv_time);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                String time = String.format("%d:%02d:%02d",
                        hours, minutes, secs);
                timeView.setText(time);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
}