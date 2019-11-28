package com.example.onlineshopproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {
TextInputEditText etUsername,etPassword;
Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etUsername=findViewById(R.id.etUsername);
        etPassword=findViewById(R.id.etPassword);
        btnSignup=findViewById(R.id.btnSignup);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etUsername.getText().toString()==null || etPassword.getText().toString()==null){
                    Toast.makeText(RegisterActivity.this, "Passwords do not match", Toast.LENGTH_LONG).show();

                }
                if(new Database(RegisterActivity.this).register(new UserModel(etUsername.getText().toString(), etPassword.getText().toString()))){
                    Toast.makeText(RegisterActivity.this, "Register successfully", Toast.LENGTH_LONG).show();
                    finish();
                }
                else
                    Toast.makeText(RegisterActivity.this, "Register failed", Toast.LENGTH_LONG).show();

            }
        });



    }

}
