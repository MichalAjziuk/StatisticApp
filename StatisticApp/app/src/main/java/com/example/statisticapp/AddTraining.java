package com.example.statisticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddTraining extends AppCompatActivity {

    private Button pBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_training);

        pBack = findViewById(R.id.backAddTraining);
        pBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddTraining.this, AssistantPanel.class));
                finish();
            }
        });
    }
}