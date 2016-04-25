package com.ozwhver.seven.gameten;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity
        implements View.OnClickListener {
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private CharSequence mTitle;
    private Button btnMaxPriorityNotification;
    private Button btnHighPriorityNotification;
    private Button btnDefaultPriorityNotification;
    private Button btnLowPriorityNotification;
    private Button btnMinPriorityNotification;
    private Button btnDefaultNotification;
    private Button btnOldTypeNotification;
    private Button btnBigTextNotification;
    private Button btnBigImageNotification;
    private Button btnInboxTypeNotification;
    private NotificationManager manager;
    private int NOTIF_REF = 1;
    private int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMaxPriorityNotification = (Button) findViewById(R.id.btnMaxPriorityNotification);
        btnHighPriorityNotification = (Button) findViewById(R.id.btnHighPriorityNotification);
        btnDefaultPriorityNotification = (Button) findViewById(R.id.btnDefaultNotification);
        btnLowPriorityNotification = (Button) findViewById(R.id.btnLowPriorityNotification);
        btnMinPriorityNotification = (Button) findViewById(R.id.btnMinPriorityNotification);
        btnDefaultNotification = (Button) findViewById(R.id.btnDefaultNotification);
        btnOldTypeNotification = (Button) findViewById(R.id.btnOldTypeNotification);
        btnBigTextNotification = (Button) findViewById(R.id.btnBigTextNotification);
        btnBigImageNotification = (Button) findViewById(R.id.btnBigImageNotification);
        btnInboxTypeNotification = (Button) findViewById(R.id.btnInboxTypeNotification);

        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); //remember

        btnMaxPriorityNotification.setOnClickListener(this);
        btnHighPriorityNotification.setOnClickListener(this);
        btnDefaultPriorityNotification.setOnClickListener(this);
        btnLowPriorityNotification.setOnClickListener(this);
        btnDefaultNotification.setOnClickListener(this);
        btnOldTypeNotification.setOnClickListener(this);
        btnBigTextNotification.setOnClickListener(this);
        btnBigImageNotification.setOnClickListener(this);
        btnInboxTypeNotification.setOnClickListener(this);
        btnMinPriorityNotification.setOnClickListener(this);







    }

    @Override
    public void onClick(View v) {//remember
        Notification notif = null;
        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_menu_camera)
                .setWhen(System.currentTimeMillis())
                .setContentText("Android Notification");
        switch (v.getId()){
            case R.id.btnMaxPriorityNotification:
                builder.setContentTitle("Maximum priority notification")
                        .setPriority(Notification.PRIORITY_MAX);
                sendNotification(builder.build());
                break;

            case R.id.btnHighPriorityNotification:
                builder.setContentTitle("High priority notification")
                        .setPriority(Notification.PRIORITY_HIGH);
                sendNotification(builder.build());
                break;
            case R.id.btnDefaultNotification:
                notif = getDefaultNotification(builder);
                sendNotification(notif);
                break;
            case R.id.btnOldTypeNotification:
                notif = getOldNotification();
                break;
            case R.id.btnBigImageNotification:
                notif = getBigPictureStyle(builder);
                sendNotification(notif);
                break;
        }
    }

    private Notification getBigPictureStyle(Notification.Builder builder) {
        Bitmap icon = BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_menu_slideshow);
        builder.setContentTitle("Reduced bigPicture title")
                .setContentText("Reduced content")
                .setContentInfo("info")
                .setSmallIcon(R.drawable.ic_menu_share)
                .setLargeIcon(icon);
        return new Notification.BigPictureStyle(builder)
                .bigPicture(icon)
                .bigLargeIcon(icon)
                .setBigContentTitle("Expended BigPicture title")
                .setSummaryText(getResources().getString(R.string.summary_text))
                .build();
    }

    private Notification getOldNotification() {
        Notification notif = new Notification(R.drawable.ic_menu_send, null, System.currentTimeMillis());
        //notif.setLatestEventInfo(this, "Old title", "Old notification content text", PendingIntent.getActivity(this, 0, new Intent(), 0));
        return notif;
    }

    private Notification getDefaultNotification(Notification.Builder builder) {
        builder.setSmallIcon(R.drawable.ic_menu_gallery)
                .setWhen(System.currentTimeMillis())
                .setContentTitle("Default notification")
                .setContentText("This is random text for default type notification")
                .setContentInfo("info");
        return builder.build();

    }

    private void sendNotification(Notification notification) {
        manager.notify(NOTIF_REF++, notification);
    }
}
