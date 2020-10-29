package com.example.digitalcontent_project.login;

import androidx.appcompat.app.AppCompatActivity;
import com.example.digitalcontent_project.R;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Id extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id);
        final EditText edit_email = findViewById(R.id.edit_email);
        final Button id_btn = findViewById(R.id.id_btn);
        id_btn.setEnabled(false); // 버튼 비활성화
        edit_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                id_btn.setEnabled(true);
            }
        });

        id_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edit_email.getText().toString().trim();
                Intent intent = new Intent(getApplication(),Password.class);
                intent.putExtra("email",email);
                startActivity(intent);
                finish();
            }
        });
    }
}