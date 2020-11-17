package com.example.statisticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlayerStats extends AppCompatActivity {

    private EditText pPlayerId, pMatchId, pPoints, pRebounds, pAssists, pSteals;
    private Button pSubmit,pBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player_stats);

        pPlayerId = findViewById(R.id.playerIdStats);
        pMatchId = findViewById(R.id.matchIdStats);
        pPoints = findViewById(R.id.points);
        pRebounds = findViewById(R.id.rebounds);
        pAssists = findViewById(R.id.assists);
        pSteals = findViewById(R.id.steals);

        pSubmit = findViewById(R.id.submit);
        pSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db = new DatabaseHelper(AddPlayerStats.this);
                String txtPlayerId = pPlayerId.getText().toString();
                String txtMatchId = pMatchId.getText().toString();
                String txtPoints = pPoints.getText().toString();
                String txtRebounds = pRebounds.getText().toString();
                String txtAssists = pAssists.getText().toString();
                String txtSteals = pSteals.getText().toString();
                int finalValPlayerId, finalValMatchId, finalValPoints, finalValRebounds, finalValAssists, finalValSteals;

                if(TextUtils.isEmpty(txtPlayerId) || TextUtils.isEmpty(txtMatchId) || TextUtils.isEmpty(txtPoints) ||
                        TextUtils.isEmpty(txtRebounds) || TextUtils.isEmpty(txtAssists) || TextUtils.isEmpty(txtSteals)){
                    Toast.makeText(AddPlayerStats.this,"Empty Credentials !",Toast.LENGTH_SHORT).show();
                } else {
                    finalValPlayerId = Integer.parseInt(txtPlayerId);
                    finalValMatchId = Integer.parseInt(txtMatchId);
                    finalValPoints = Integer.parseInt(txtPoints);
                    finalValRebounds = Integer.parseInt(txtRebounds);
                    finalValAssists = Integer.parseInt(txtAssists);
                    finalValSteals = Integer.parseInt(txtSteals);
                    PlayerStats playerStats = new PlayerStats(finalValPlayerId,finalValMatchId,finalValPoints,finalValRebounds,
                            finalValAssists,finalValSteals);
                    db.addPlayerStats(playerStats);
                    Toast.makeText(AddPlayerStats.this, "You add a player statistics from match ", Toast.LENGTH_SHORT).show();
                    pPlayerId.getText().clear();
                    pMatchId.getText().clear();
                    pPoints.getText().clear();
                    pRebounds.getText().clear();
                    pAssists.getText().clear();
                    pSteals.getText().clear();
                }
            }
        });


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