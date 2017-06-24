package com.turtledev.menu;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * Created by 1 on 18.04.2016.
 */
public class MAinActivity extends AppCompatActivity {

    private NotificationManager nm;
    private final int NOTIFICATION_ID=123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        nm=(NotificationManager)getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.setting:
                Toast.makeText(this,"Settings",Toast.LENGTH_SHORT).show();
            case R.id.clock:
                Toast.makeText(this,"clock",Toast.LENGTH_SHORT).show();
            case R.id.mail:
                Toast.makeText(this,"mail",Toast.LENGTH_SHORT).show();
            case R.id.camera:
                Toast.makeText(this,"camera",Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }


    public void showNotification(View view){
        Notification.Builder builder = new Notification.Builder(getApplicationContext());
        Intent intent =new Intent(this,FinishActivity.class);
        PendingIntent pendingintent =PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder
                .setContentIntent(pendingintent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(),R.mipmap.ic_launcher))
                .setTicker("New story")
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentTitle("Yvedomlenie")
                .setContentText("Нажміть щоб дізнатись таємницю")
                .setProgress(100, 30, true);
        Notification notification=builder.build();
        notification.defaults=Notification.DEFAULT_ALL;
        notification.flags=notification.flags | Notification.FLAG_ONGOING_EVENT;

        nm.notify(NOTIFICATION_ID,notification);

    }


    public void cancelNotification(View view){
        nm.cancel(NOTIFICATION_ID);
    }
}
