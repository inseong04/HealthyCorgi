package com.example.digitalcontent_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.Calendar;

public class Setting_Time extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting__time);
        TimePicker mTimePicker = findViewById(R.id.timepicker);
        Calendar mCalendar = Calendar.getInstance();

        int hour,min;

        if (Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M){ // TimePicker에서 시간,분을 받아옴.
            hour = mTimePicker.getHour();
            min = mTimePicker.getMinute();
        }
        else { // API23 이전
            hour = mTimePicker.getCurrentHour();
            min = mTimePicker.getCurrentMinute();
        }
    }
}