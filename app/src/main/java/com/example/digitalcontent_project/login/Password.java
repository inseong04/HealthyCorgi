package com.example.digitalcontent_project.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.digitalcontent_project.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class Password extends AppCompatActivity {

    private String TAG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        final EditText input_password = findViewById(R.id.input_password);
        final EditText input_repassword = findViewById(R.id.input_repassword);
        final Button password_btn = findViewById(R.id.password_btn);
        final TextView password_disagree = findViewById(R.id.password_disagree);
        final TextView password_error = findViewById(R.id.password_error);
        final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(); // firebaseAuth의 인스턴스를 가져온다.
        final FirebaseFirestore firestoreDB = FirebaseFirestore.getInstance();

        password_btn.setEnabled(false); // 버튼 비활성화
        final String password = input_password.getText().toString();
        input_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(password.length() <= 6){
                    password_error.setVisibility(View.VISIBLE); // 6자 이상 입력해주세요.
                }
                else if(password.length() > 6){
                    password_error.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(password.length() <= 6){
                    password_error.setVisibility(View.VISIBLE); // 6자 이상 입력해주세요.
                }
                else if(password.length() > 6){
                    password_error.setVisibility(View.GONE);
                }
            }
        });

        input_repassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 입력전
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 입력중
                String repassword = input_repassword.getText().toString();
                if (password.equals(repassword)){
                    password_btn.setEnabled(true); // 버튼 활성화
                    password_disagree.setVisibility(View.GONE);
                }
                else{
                    password_disagree.setVisibility(View.VISIBLE); // 비밀번호가 일치하지않습니다.
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // 입력후
                String repassword = input_repassword.getText().toString();
                if (password.equals(repassword)){
                    password_btn.setEnabled(true); // 버튼 활성화
                    password_disagree.setVisibility(View.GONE);
                }
                else{
                    password_disagree.setVisibility(View.VISIBLE); // 비밀번호가 일치하지않습니다.
                }
            }
        });
        password_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = getIntent();
                String email = intent1.getExtras().getString("email");
                String pwd = input_password.getText().toString().trim();
                Log.e(TAG,"email : " +email);
                Log.e(TAG,"pwd : " +pwd);
                firebaseAuth.createUserWithEmailAndPassword(email, pwd)
                        .addOnCompleteListener(Password.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

// 이메일주소와 비밀번호를 creatUserWithEmailAndPassword에 전달하여 신규 계정을 생성한다.
                                if (task.isSuccessful()) { // 성공일경우 로그인화면으로 넘어간다.
                                    final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                    String user_uid = user.getUid();
                                    Map<String, Object> user_information = new HashMap<>();
                                    user_information.put("First Attempt", "First");

                                    firestoreDB.collection("users").document(user_uid)
                                            .set(user_information)
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void aVoid) {
                                                    Intent intent = new Intent(getApplication(),Login.class);
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
                                    Toast.makeText(Password.this, "등록 에러가 발생했습니다.", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            }
                        });

            }
        });
    }
}