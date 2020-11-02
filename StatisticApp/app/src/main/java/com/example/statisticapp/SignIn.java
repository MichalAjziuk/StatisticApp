package com.example.statisticapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.util.Map;

public class SignIn extends AppCompatActivity {

    DatabaseHelper db;
    private EditText mEmail, mPassword;
    private Button mSignIn, mSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        db = new DatabaseHelper(this);

        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mSignIn = findViewById(R.id.signin_button);
        mSignUp = findViewById(R.id.signup_button);


        mSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtEmail = mEmail.getText().toString();
                String txtPassword = mPassword.getText().toString();
                boolean chcEmPass = db.checkEmailAndPassword(txtEmail, txtPassword);
                String role = db.checkRole(txtEmail);
                System.out.println(role);

                if (TextUtils.isEmpty(txtEmail) || TextUtils.isEmpty(txtPassword)) {
                    Toast.makeText(SignIn.this, "Empty fields !!", Toast.LENGTH_SHORT).show();
                } else if (chcEmPass) {
                    if (role.equals("Coach")) {
                        Toast.makeText(SignIn.this, "Successfully Login !", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignIn.this,CoachPanel.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(SignIn.this, "Successfully Login !", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignIn.this, AssistantPanel.class);
                        startActivity(intent);
                    }
                }
                /*Toast.makeText(SignIn.this, "Successfully Login !", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignIn.this,CoachPanel.class);
                startActivity(intent);*/
            }
        });


        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignIn.this, SignUp.class));
                finish();
            }
        });
    }



}