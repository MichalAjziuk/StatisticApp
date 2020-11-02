package com.example.statisticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddPlayerStats extends AppCompatActivity {

    private Button pBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player_stats);


        pBack = findViewById(R.id.backAddPlayerStats);
        pBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddPlayerStats.this, AssistantPanel.class));
                finish();
            }
        });

    }
}