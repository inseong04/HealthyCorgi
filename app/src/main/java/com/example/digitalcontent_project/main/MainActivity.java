package com.example.digitalcontent_project.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.digitalcontent_project.User_Information;
import com.example.digitalcontent_project.fragment.Fragment1;
import com.example.digitalcontent_project.chat.Fragment_Chat;
import com.example.digitalcontent_project.fragment.Fragment3;
import com.example.digitalcontent_project.fragment.Fragment4;
import com.example.digitalcontent_project.fragment.Fragment5;
import com.example.digitalcontent_project.R;
import com.example.digitalcontent_project.Test;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private String TAG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button testbtn = findViewById(R.id.testbtn);
        final FragmentManager fragmentmanager = getSupportFragmentManager();
        final Fragment1 fragment1 = new Fragment1();
        final Fragment_Chat fragmentChat = new Fragment_Chat();
        final Fragment3 fragment3 = new Fragment3();
        final Fragment4 fragment4 = new Fragment4();
        final Fragment5 fragment5 = new Fragment5();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomview);
        final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        final FirebaseFirestore firestoreDB = FirebaseFirestore.getInstance();
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String user_uid = user.getUid(); // 유저 고유 uid값.
        final TextView asdf = findViewById(R.id.asdf);
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
                        transaction.replace(R.id.framelayout, fragmentChat).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.menu3 : {
                        transaction.replace(R.id.framelayout,fragment3).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.menu4 : {
                        transaction.replace(R.id.framelayout,fragment4).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.menu5 : {
                        transaction.replace(R.id.framelayout,fragment5).commitAllowingStateLoss();
                        break;
                    }
                }
                return true;
            }
        });



        firestoreDB.collection("users").document(user_uid)
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {

                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()){
                            final String firstattempt;
                            DocumentSnapshot document = task.getResult();
                            Map<String,Object> map = new HashMap<>();
                            Log.e(TAG,"document : " + document.getData());
                            map = document.getData();

                            Log.e(TAG,"firstattept : " + document.getData());

                            if (map.get("First Attempt") != null) {
                                String first_attempt = document.get("First Attempt").toString();
                                Log.e(TAG,"aaaaa"+first_attempt);
                                if(first_attempt.equals("First")){
                                    Intent intent = new Intent(getApplication(), User_Information.class);
                                    startActivity(intent);
                                }

                            }
                        }
                        else {
                            Log.d(TAG, "No such document");
                        }
                    }
                });

        testbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Test.class);
                startActivity(intent);
            }
        });
    }
}

