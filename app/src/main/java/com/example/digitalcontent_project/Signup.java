package com.example.digitalcontent_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        final EditText signup_edittext_user_id = findViewById(R.id.signup_edittext_user_id);
        final EditText signup_edittext_user_password = findViewById(R.id.signup_edittext_user_password);
        Button signup_button = findViewById(R.id.signup_button);
        final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(); // firebaseAuth의 인스턴스를 가져온다.
        final FirebaseFirestore firestoreDB = FirebaseFirestore.getInstance();
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = signup_edittext_user_id.getText().toString().trim();
                String pwd = signup_edittext_user_password.getText().toString().trim();

                firebaseAuth.createUserWithEmailAndPassword(email, pwd)
                        .addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

// 이메일주소와 비밀번호를 creatUserWithEmailAndPassword에 전달하여 신규 계정을 생성한다.
                                if (task.isSuccessful()) { // 성공적일경우 로그인화면으로 넘어간다.
                                    String user_uid = user.getUid();
                                    Map<String,Object> user_information = new HashMap<>();
                                    user_information.put("First Attempt",0);

                                    firestoreDB.collection("users").document(user_uid)
                                            .set(user_information)
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void aVoid) {
                                                    Intent intent = new Intent(Signup.this, Login.class);
                                                    startActivity(intent);
                                                    finish();
                                                }

                                            })
                                            .addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {

                                                }
                                            });

                                } else { // 아닐경우 등록 에러가 발생했다는 문구를 띄운다.
                                    Toast.makeText(Signup.this, "등록 에러가 발생했습니다.", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            }
                        });
            }
        });
        }
    }