package com.example.statisticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CoachPanel extends AppCompatActivity {

    private Button cPlayer, cMatches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_panel);

        cPlayer = findViewById(R.id.players);
        cPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CoachPanel.this, PlayersList.class));
                finish();
            }
        });

        cMatches = findViewById(R.id.matches);
        cMatches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CoachPanel.this, MatchesList.class));
                finish();
            }
        });
    }
}