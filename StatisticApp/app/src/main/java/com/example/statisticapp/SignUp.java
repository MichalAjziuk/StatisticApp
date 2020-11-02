package com.example.statisticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


public class SignUp extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText mEmail, mPassword;
    private Spinner mTeam;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButton;
    private Button mSignUpButton, mBackButton, mDeleteDB;
    private String txtTeam;
    private User user;
    private DatabaseHelper databaseHelper = new DatabaseHelper(SignUp.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mPassword = findViewById(R.id.password);
        mEmail = findViewById(R.id.email);

        mTeam = findViewById(R.id.chooseTeam);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.teams, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mTeam.setAdapter(adapter);
        mTeam.setOnItemSelectedListener(this);

        mRadioGroup = findViewById(R.id.radioGroup);

        mSignUpButton = findViewById(R.id.SignUpButton);
        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtEmail = mEmail.getText().toString();
                String txtPassword = mPassword.getText().toString();
                int radioId = mRadioGroup.getCheckedRadioButtonId();
                mRadioButton = findViewById(radioId);
                String txtRole = (String) mRadioButton.getText();
                Boolean checkEmail = databaseHelper.checkEmail(txtEmail);

                if(TextUtils.isEmpty(txtEmail) || TextUtils.isEmpty(txtPassword)){
                    Toast.makeText(SignUp.this, "Empty credentials!", Toast.LENGTH_SHORT).show();
                } else if (txtPassword.length() < 6) {
                    Toast.makeText(SignUp.this, "Password too short!", Toast.LENGTH_SHORT).show();
                } else if (!checkEmail) {
                    Toast.makeText(SignUp.this, "This email exist in database, write different ", Toast.LENGTH_SHORT).show();
                } else {
                    user = new User(txtEmail,txtPassword,txtTeam,txtRole);
                    databaseHelper.addUser(user);
                    Toast.makeText(SignUp.this, "Success registration", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUp.this, SignIn.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        mBackButton = findViewById(R.id.backButton);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, SignIn.class);
                startActivity(intent);
                finish();
            }
        });

        mDeleteDB = findViewById(R.id.deleteDB);
        mDeleteDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseHelper.dropTable();
            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        txtTeam = adapterView.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}