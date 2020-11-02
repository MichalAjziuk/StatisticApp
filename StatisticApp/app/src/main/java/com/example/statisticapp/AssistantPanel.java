package com.example.statisticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AssistantPanel extends AppCompatActivity {

    private Button aAddPlayer, aAddPlayerProgress, aAddTraining, aAddMatch, aAddPlayerStats, aEditPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assistant_panel);

        aAddPlayer = findViewById(R.id.addPlayer);
        aAddPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AssistantPanel.this, AddPlayer.class);
                startActivity(intent);
                finish();
            }
        });

        aAddPlayerProgress = findViewById(R.id.addPlayerProgress);
        aAddPlayerProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AssistantPanel.this, AddPlayerProgress.class);
                startActivity(intent);
                finish();
            }
        });

        aAddTraining = findViewById(R.id.addTraining);
        aAddTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AssistantPanel.this, AddTraining.class);
                startActivity(intent);
                finish();
            }
        });

        aAddMatch = findViewById(R.id.addMatch);
        aAddMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AssistantPanel.this, AddMatch.class);
                startActivity(intent);
                finish();
            }
        });

        aAddPlayerStats = findViewById(R.id.addPlayerStats);
        aAddPlayerStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AssistantPanel.this, AddPlayerStats.class);
                startActivity(intent);
                finish();
            }
        });

        aEditPlayer = findViewById(R.id.editPlayer);
        aEditPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AssistantPanel.this, EditPlayer.class);
                startActivity(intent);
                finish();
            }
        });

    }
}