package com.example.digitalcontent_project;

import androidx.appcompat.app.AppCompatActivity;

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
    }
}