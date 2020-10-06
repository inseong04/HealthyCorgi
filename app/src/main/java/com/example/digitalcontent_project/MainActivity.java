package com.example.digitalcontent_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button testbtn = findViewById(R.id.testbtn);
        final FragmentManager fragmentmanager = getSupportFragmentManager();
        final Fragment1 fragment1 = new Fragment1();
        final Fragment2 fragment2 = new Fragment2();
        final Fragment3 fragment3 = new Fragment3();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomview);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction transaction = fragmentmanager.beginTransaction();
                switch (menuItem.getItemId()){
                    case R.id.menu1 : {
                        transaction.replace(R.id.framelayout,fragment1).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.menu2 : {
                        transaction.replace(R.id.framelayout,fragment2).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.menu3 : {
                        transaction.replace(R.id.framelayout,fragment3).commitAllowingStateLoss();
                        break;
                    }
                }
                return true;
            }
        });

        testbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Test.class);
                startActivity(intent);
            }
        });
    }
}