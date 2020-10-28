package com.example.digitalcontent_project.login;

import androidx.appcompat.app.AppCompatActivity;
import com.example.digitalcontent_project.R;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

public class Id extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id);
        EditText email = findViewById(R.id.email);
        final Button id_btn = findViewById(R.id.id_btn);
        id_btn.setEnabled(false); // 버튼 비활성화
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                id_btn.setEnabled(false);
            }
        });
    }
}