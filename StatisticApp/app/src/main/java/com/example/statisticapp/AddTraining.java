package com.example.statisticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddTraining extends AppCompatActivity {

    private EditText tName, tInfo, tTime, tIntensity, tDynamic;
    private Button tSubmit, tBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_training);

        tName = findViewById(R.id.nameTraining);
        tInfo = findViewById(R.id.info);
        tTime = findViewById(R.id.time);
        tIntensity = findViewById(R.id.intensity);
        tDynamic = findViewById(R.id.dynamic);

        tSubmit = findViewById(R.id.submit);
        tSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db = new DatabaseHelper(AddTraining.this);
                String txtName = tName.getText().toString();
                String txtInfo = tInfo.getText().toString();
                String txtIntensity = tIntensity.getText().toString();
                String txtDynamic = tDynamic.getText().toString();
                String txtTime = tTime.getText().toString();
                int finalValTime;

                if(TextUtils.isEmpty(txtName) || TextUtils.isEmpty(txtInfo) || TextUtils.isEmpty(txtIntensity) ||
                        TextUtils.isEmpty(txtDynamic) || TextUtils.isEmpty(txtTime) ) {
                    Toast.makeText(AddTraining.this, "Empty credentials!", Toast.LENGTH_SHORT).show();
                } else {
                    finalValTime = Integer.parseInt(txtTime);
                    Training training = new Training(txtName,finalValTime,txtInfo,txtIntensity,txtDynamic);
                    db.addTraining(training);
                    Toast.makeText(AddTraining.this, "You add a training !", Toast.LENGTH_SHORT).show();
                    tName.getText().clear();
                    tInfo.getText().clear();
                    tTime.getText().clear();
                    tIntensity.getText().clear();
                    tDynamic.getText().clear();
                }
            }
        });

        tBack = findViewById(R.id.backAddTraining);
        tBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddTraining.this, AssistantPanel.class));
                finish();
            }
        });
    }
}