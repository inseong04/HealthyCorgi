package com.example.digitalcontent_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class User_Information extends AppCompatActivity {
    private String TAG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__information);

        EditText user_name = findViewById(R.id.user_name);
        EditText user_year = findViewById(R.id.user_year);
        EditText user_day = findViewById(R.id.user_day);
        EditText user_disease = findViewById(R.id.user_disease);
        EditText user_record = findViewById(R.id.user_record);
        EditText user_allergy = findViewById(R.id.user_allergy);
        EditText user_blood = findViewById(R.id.user_blood);
        EditText user_height = findViewById(R.id.user_height);
        EditText user_weight = findViewById(R.id.user_weight);
        Spinner user_month = findViewById(R.id.user_month);
        Button save_date = findViewById(R.id.save_date);
        final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(); // firebaseAuth의 인스턴스를 가져온다.
        final FirebaseFirestore firestoreDB = FirebaseFirestore.getInstance();
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String user_uid = user.getUid();
        final String name = user_name.getText().toString().trim();
        final String year = user_year.getText().toString().trim();
        final String day = user_day.getText().toString().trim();
        String disease = user_disease.getText().toString().trim();
        String record = user_record.getText().toString().trim();
        String allergy = user_allergy.getText().toString().trim();
        final String blood = user_blood.getText().toString().trim();
        final String height = user_height.getText().toString().trim();
        final String weight = user_weight.getText().toString().trim();
        final String month = user_month.getSelectedItem().toString();
        //Edittext에서 받아와지지 않음
        ///
        save_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, Object> user_information = new HashMap<>();
                user_information.put("Name", name);
                user_information.put("Year",year);
                user_information.put("Month",month);
                user_information.put("Day",day);
                user_information.put("Blood",blood);
                user_information.put("Height",height);
                user_information.put("Weight",weight);
                Log.e(TAG,"name : " + name);
                Log.e(TAG,"year : " + year);
                Log.e(TAG,"month : " + month);
                Log.e(TAG,"day : "+day);
                Log.e(TAG,"blood : "+blood );
                Log.e(TAG,"height : "+height);
                Log.e(TAG,"weight : "+weight);
                // 데이터가 " " 의 형태로만 받아와짐.
                firestoreDB.collection("users").document(user_uid)
                        .set(user_information)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }
                        });
            }
        });
    }
}