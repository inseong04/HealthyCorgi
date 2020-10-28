package com.example.digitalcontent_project.login;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.digitalcontent_project.R;

import org.w3c.dom.Text;

public class Password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        final EditText input_password = findViewById(R.id.input_password);
        final EditText input_repassword = findViewById(R.id.input_repassword);
        final Button password_btn = findViewById(R.id.password_btn);
        final TextView password_disagree = findViewById(R.id.password_disagree);
        final TextView password_error = findViewById(R.id.password_error);
        password_btn.setEnabled(false); // 버튼 비활성화
        final String password = input_password.getText().toString();
        input_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(password.length() <= 6){
                    password_error.setVisibility(View.VISIBLE); // 6자 이상 입력해주세요.
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
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // 입력후
                String repassword = input_repassword.getText().toString();
                if (password == repassword){
                    password_btn.setEnabled(true); // 버튼 활성화
                }
                else{
                    password_disagree.setVisibility(View.VISIBLE); // 비밀번호가 일치하지않습니다.
                }
            }
        });
    }
}