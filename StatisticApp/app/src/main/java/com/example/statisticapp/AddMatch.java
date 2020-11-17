package com.example.statisticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class AddMatch extends AppCompatActivity {

    private EditText mNameTM1, mNameTM2, mDateOfMatch, mTm1S, mTm2S, mQT1TM1, mQT2TM1, mQT3TM1, mQT4TM1, mQT1TM2,
            mQT2TM2, mQT3TM2, mQT4TM2, mOvertime, mBPTM1, mBPTM2;
    private Button mBack, mSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_match);

        mNameTM1 = findViewById(R.id.nameTeamOne);
        mNameTM2 = findViewById(R.id.nameTeamTwo);
        mDateOfMatch = findViewById(R.id.dateofmatch);
        mTm1S = findViewById(R.id.teamOneScore);
        mTm2S = findViewById(R.id.teamTwoScore);
        mQT1TM1 = findViewById(R.id.qt1tm1);
        mQT2TM1 = findViewById(R.id.qt2tm1);
        mQT3TM1 = findViewById(R.id.qt3tm1);
        mQT4TM1 = findViewById(R.id.qt4tm1);
        mQT1TM2 = findViewById(R.id.qt1tm2);
        mQT2TM2 = findViewById(R.id.qt2tm2);
        mQT3TM2 = findViewById(R.id.qt3tm2);
        mQT4TM2 = findViewById(R.id.qt4tm2);
        mOvertime = findViewById(R.id.overtime);
        mBPTM1 = findViewById(R.id.bptm1);
        mBPTM2 = findViewById(R.id.bptm2);

        mSubmit = findViewById(R.id.submitAddMatch);
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper databaseHelper = new DatabaseHelper(AddMatch.this);
                String txtNameTM1 = mNameTM1.getText().toString();
                String txtNameTM2 = mNameTM2.getText().toString();
                String txtDateOfMatch = mDateOfMatch.getText().toString();
                String valTm1S = mTm1S.getText().toString();
                String valTm2S = mTm2S.getText().toString();
                String valQT1TM1 = mQT1TM1.getText().toString();
                String valQT2TM1 = mQT2TM1.getText().toString();
                String valQT3TM1 = mQT3TM1.getText().toString();
                String valQT4TM1 = mQT4TM1.getText().toString();
                String valQT1TM2 = mQT1TM2.getText().toString();
                String valQT2TM2 = mQT2TM2.getText().toString();
                String valQT3TM2 = mQT3TM2.getText().toString();
                String valQT4TM2 = mQT4TM2.getText().toString();
                int finalValTm1S,finalValTm2S,finalValQT1TM1,finalValQT2TM1,finalValQT3TM1,finalValQT4TM1,finalValQT1TM2, finalValQT2TM2, finalValQT3TM2, finalValQT4TM2;
                String txtOvertime = mOvertime.getText().toString();
                String txtBPTM1 = mBPTM1.getText().toString();
                String txtBPTM2 = mBPTM2.getText().toString();

                if(TextUtils.isEmpty(txtNameTM1) || TextUtils.isEmpty(txtNameTM2) ||TextUtils.isEmpty(txtDateOfMatch) || TextUtils.isEmpty(valTm1S) || TextUtils.isEmpty(valTm2S) || TextUtils.isEmpty(valQT1TM1) || TextUtils.isEmpty(valQT2TM1) ||
                        TextUtils.isEmpty(valQT3TM1) || TextUtils.isEmpty(valQT4TM1) || TextUtils.isEmpty(valQT1TM2) || TextUtils.isEmpty(valQT2TM2) || TextUtils.isEmpty(valQT3TM2) ||
                        TextUtils.isEmpty(valQT4TM2) || TextUtils.isEmpty(txtOvertime) || TextUtils.isEmpty(txtBPTM1) || TextUtils.isEmpty(txtBPTM2) ){
                    Toast.makeText(AddMatch.this, "Empty credentials!", Toast.LENGTH_SHORT).show();
                } else {
                    finalValTm1S = Integer.parseInt(valTm1S);
                    finalValTm2S = Integer.parseInt(valTm2S);
                    finalValQT1TM1 = Integer.parseInt(valQT1TM1);
                    finalValQT2TM1 = Integer.parseInt(valQT2TM1);
                    finalValQT3TM1 = Integer.parseInt(valQT3TM1);
                    finalValQT4TM1 = Integer.parseInt(valQT4TM1);
                    finalValQT1TM2 = Integer.parseInt(valQT1TM2);
                    finalValQT2TM2 = Integer.parseInt(valQT2TM2);
                    finalValQT3TM2 = Integer.parseInt(valQT3TM2);
                    finalValQT4TM2 = Integer.parseInt(valQT4TM2);
                    Match match = new Match(txtNameTM1,txtNameTM2,txtDateOfMatch,finalValTm1S,finalValTm2S,finalValQT1TM1,finalValQT2TM1,finalValQT3TM1,finalValQT4TM1,finalValQT1TM2,finalValQT2TM2,
                            finalValQT3TM2,finalValQT4TM2,txtOvertime,txtBPTM1,txtBPTM2);
                    databaseHelper.addMatch(match);
                    Toast.makeText(AddMatch.this, "You add a match !", Toast.LENGTH_SHORT).show();
                    mNameTM1.getText().clear();
                    mNameTM2.getText().clear();
                    mDateOfMatch.getText().clear();
                    mTm1S.getText().clear();
                    mTm2S.getText().clear();
                    mQT1TM1.getText().clear();
                    mQT2TM1.getText().clear();
                    mQT3TM1.getText().clear();
                    mQT4TM1.getText().clear();
                    mQT1TM2.getText().clear();
                    mQT2TM2.getText().clear();
                    mQT3TM2.getText().clear();
                    mQT4TM2.getText().clear();
                    mOvertime.getText().clear();
                    mBPTM1.getText().clear();
                    mBPTM2.getText().clear();
                }



            }
        });

        mBack = findViewById(R.id.backAddMatch);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddMatch.this, AssistantPanel.class));
                finish();
            }
        });
    }
}