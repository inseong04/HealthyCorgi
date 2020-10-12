package com.example.digitalcontent_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        final Button go_setting_time = findViewById(R.id.go_setting_time);
        Button go_user_information = findViewById(R.id.go_user_information);
        Button pushnotification = findViewById(R.id.push);

        PendingIntent mPendingintent = PendingIntent.getActivity(Test.this,0,
                new Intent(getApplicationContext(),MainActivity.class)
                ,PendingIntent.FLAG_UPDATE_CURRENT);

        final   NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(Test.this)
                        .setSmallIcon(R.drawable.ic_android_black_24dp)
                        .setContentTitle("앱 제목")
                        .setContentText("약을 복용해주세요!")
                        .setDefaults(Notification.DEFAULT_VIBRATE)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setAutoCancel(true)
                        .setContentIntent(mPendingintent);
        // 푸시알림 보내지지않음.
        final NotificationManager mNotificationManager =
                (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        go_setting_time.setOnClickListener(new View.OnClickListener() { // Setting_Time로 이동
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Setting_Time.class);
                startActivity(intent);
            }
        });

        go_user_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),User_Information.class);
                startActivity(intent);
            }
        });
        pushnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mNotificationManager.notify(1,mBuilder.build());

            }
        });
    }
}