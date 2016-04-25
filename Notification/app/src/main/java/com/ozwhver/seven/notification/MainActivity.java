package com.ozwhver.seven.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button) findViewById(R.id.button1);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0); //set intent as pending

        Notification noti = new Notification.Builder(this).setTicker("Ticker Title")
                .setContentTitle("Notification Content Title")
                .setContentText("Notification Content")
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentIntent(pIntent).getNotification();//create notification object
        noti.flags = Notification.FLAG_AUTO_CANCEL;//make flag to close notification when touched
        //start notification manager
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //display notification
        notificationManager.notify(0, noti);



    }
}
