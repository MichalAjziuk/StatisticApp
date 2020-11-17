package com.example.statisticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlayerProgress extends AppCompatActivity {

    private EditText pPlayerId, pTrainingId, pDateOfTraining, pPhysical, pFatigue, pSpeed, pJumping, pMusculature, pSatisfaction;
    private Button pBack, pSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player_progress);

        pPlayerId = findViewById(R.id.playerIdProgress);
        pTrainingId = findViewById(R.id.trainingId);
        pDateOfTraining = findViewById(R.id.dateoftraining);
        pPhysical = findViewById(R.id.physical);
        pFatigue = findViewById(R.id.fatigue);
        pSpeed = findViewById(R.id.speed);
        pJumping = findViewById(R.id.jumping);
        pMusculature = findViewById(R.id.musculature);
        pSatisfaction = findViewById(R.id.satisfaction);

        pSubmit = findViewById(R.id.submit);
        pSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db = new DatabaseHelper(AddPlayerProgress.this);
                String txtPlayerId = pPlayerId.getText().toString();
                String txtTrainingId = pTrainingId.getText().toString();
                String txtDateofTraining = pDateOfTraining.getText().toString();
                String txtPhysical = pPhysical.getText().toString();
                String txtFatigue = pFatigue.getText().toString();
                String txtSpeed = pSpeed.getText().toString();
                String txtJumping = pJumping.getText().toString();
                String txtMusculature = pMusculature.getText().toString();
                String txtSatisfaction = pSatisfaction.getText().toString();
                int finalValPlayerId, finalValTrainingId, finalValFatigue, finalValSpeed, finalValJumping, finalValMusculature;

                if(TextUtils.isEmpty(txtPlayerId) || TextUtils.isEmpty(txtTrainingId) || TextUtils.isEmpty(txtDateofTraining) || TextUtils.isEmpty(txtPhysical) ||
                        TextUtils.isEmpty(txtFatigue) || TextUtils.isEmpty(txtSpeed) || TextUtils.isEmpty(txtJumping) || TextUtils.isEmpty(txtMusculature) ||
                        TextUtils.isEmpty(txtSatisfaction) ){
                    Toast.makeText(AddPlayerProgress.this, "Empty credentials!", Toast.LENGTH_SHORT).show();
                } else {
                    finalValPlayerId = Integer.parseInt(txtPlayerId);
                    finalValTrainingId = Integer.parseInt(txtTrainingId);
                    finalValFatigue = Integer.parseInt(txtFatigue);
                    finalValSpeed = Integer.parseInt(txtSpeed);
                    finalValJumping = Integer.parseInt(txtJumping);
                    finalValMusculature = Integer.parseInt(txtMusculature);
                    PlayerProgress playerProgress = new PlayerProgress(finalValPlayerId,finalValTrainingId,txtDateofTraining,txtPhysical,finalValFatigue,finalValSpeed,
                            finalValJumping, finalValMusculature, txtSatisfaction);
                    db.addPlayerProgress(playerProgress);
                    Toast.makeText(AddPlayerProgress.this, "You add a training !", Toast.LENGTH_SHORT).show();
                    pPlayerId.getText().clear();
                    pTrainingId.getText().clear();
                    pDateOfTraining.getText().clear();
                    pPhysical.getText().clear();
                    pFatigue.getText().clear();
                    pSpeed.getText().clear();
                    pJumping.getText().clear();
                    pMusculature.getText().clear();
                    pSatisfaction.getText().clear();
                }
            }
        });

        pBack = findViewById(R.id.backAddPlayerProgress);
        pBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddPlayerProgress.this, AssistantPanel.class));
                finish();
            }
        });
    }
}