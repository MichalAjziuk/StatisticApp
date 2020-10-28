package com.example.statisticapp;

import androidx.annotation.NonNull;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SignUp extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private FirebaseAuth mAuth;
    private EditText mEmail, mPassword;
    private Spinner mTeam;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButton;
    private Button mSignUpButton, mBackButton;
    private String textTeam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
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
                String role = (String) mRadioButton.getText();

                if(TextUtils.isEmpty(txtEmail) || TextUtils.isEmpty(txtPassword)){
                    Toast.makeText(SignUp.this, "Empty credentials!", Toast.LENGTH_SHORT).show();
                } else if (txtPassword.length() < 6){
                    Toast.makeText(SignUp.this, "Password too short!", Toast.LENGTH_SHORT).show();
                } else {
                    registerUser(txtEmail , txtPassword, textTeam, role);
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

    }

    private void registerUser(final String email, final String password, final String team, final String role){
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    String uid = mAuth.getCurrentUser().getUid();
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("Email",email);
                    map.put("Password",password);
                    map.put("Team",team);
                    map.put("Role",role);
                    FirebaseDatabase.getInstance().getReference("Users").child(uid).setValue(map);
                    Toast.makeText(SignUp.this, "Registration completed !", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUp.this, SignIn.class));
                    finish();
                } else {
                    Toast.makeText(SignUp.this, "Registration failed ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        textTeam = adapterView.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}