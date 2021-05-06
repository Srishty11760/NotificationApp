package com.example.q13notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final String cid = "MyChannel1ID";
    private static final String cname = "MyChannel2Name";
    private static final String cdesc = "MyChannel3Desc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel nc = new NotificationChannel(cid, cname, NotificationManager.IMPORTANCE_DEFAULT);
            nc.setDescription(cdesc);
            NotificationManager mgrn = getSystemService(NotificationManager.class);
            mgrn.createNotificationChannel(nc);
        }

        findViewById(R.id.button).setOnClickListener((v) -> {
                displayNotification();
        });
    }

    private void displayNotification() {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, "MyChannel1ID")
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle("Hey! I am making a new channel!")
                .setContentText("This is my first notification...")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat mNotificationMgr = NotificationManagerCompat.from(this);
        mNotificationMgr.notify(1,mBuilder.build());
    }
}