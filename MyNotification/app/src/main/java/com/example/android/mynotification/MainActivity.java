package com.example.android.mynotification;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

//    NotificationManager notificationManager;

    stopForeground( false );
notificationManager.cancel(NOTIFICATION_ID);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
//        notificationManager.cancel(NOTIFICATION_ID);

//         notificationManager.cancelAll();

        notificationManager.deleteNotificationChannel("amy1");

        //https://stackoverflow.com/questions/19268450/how-to-remove-notification-from-notification-bar-programmatically-in-android



    }
}
