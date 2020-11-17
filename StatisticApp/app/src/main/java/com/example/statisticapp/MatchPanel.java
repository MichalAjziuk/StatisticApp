package com.example.statisticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MatchPanel extends AppCompatActivity {

    private TextView mTeam1, mTeam2, mScoreTM1, mScoreTM2,
            mQT1TM1, mQT2TM1, mQT3TM1, mQT4TM1,
            mQT1TM2, mQT2TM2, mQT3TM2, mQT4TM2,
            mBPTM1,mBPTM2, mTeam1Small, mTeam2Small;
    private Button mBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_panel);
        DatabaseHelper db = new DatabaseHelper(MatchPanel.this);

        mTeam1 = findViewById(R.id.team1);
        mTeam2 = findViewById(R.id.team2);
        mTeam1Small = findViewById(R.id.team1Small);
        mTeam2Small = findViewById(R.id.team2Small);
        mScoreTM1 = findViewById(R.id.scoreTeam1);
        mScoreTM2 = findViewById(R.id.scoreTeam2);
        mQT1TM1 = findViewById(R.id.QT1TM1S);
        mQT2TM1 = findViewById(R.id.QT2TM1S);
        mQT3TM1 = findViewById(R.id.QT3TM1S);
        mQT4TM1 = findViewById(R.id.QT4TM1S);
        mQT1TM2 = findViewById(R.id.QT1TM2S);
        mQT2TM2 = findViewById(R.id.QT2TM2S);
        mQT3TM2 = findViewById(R.id.QT3TM2S);
        mQT4TM2 = findViewById(R.id.QT4TM2S);
        mBPTM1 = findViewById(R.id.BPTM1);
        mBPTM2 = findViewById(R.id.BPTM2);

        Bundle extras = getIntent().getExtras();
        int match_id = extras.getInt("id");
        Match match = db.getMatch(match_id);

        mTeam1.setText(match.getNameTeam1());
        mTeam2.setText(match.getNameTeam2());
        mTeam1Small.setText(match.getNameTeam1());
        mTeam2Small.setText(match.getNameTeam2());
        mScoreTM1.setText(String.valueOf(match.getTeam1score()));
        mScoreTM2.setText(String.valueOf(match.getTeam2score()));
        mQT1TM1.setText(String.valueOf(match.getQt1team1()));
        mQT2TM1.setText(String.valueOf(match.getQt2team1()));
        mQT3TM1.setText(String.valueOf(match.getQt3team1()));
        mQT4TM1.setText(String.valueOf(match.getQt4team1()));
        mQT1TM2.setText(String.valueOf(match.getQt1team2()));
        mQT2TM2.setText(String.valueOf(match.getQt2team2()));
        mQT3TM2.setText(String.valueOf(match.getQt3team2()));
        mQT4TM2.setText(String.valueOf(match.getQt4team2()));
        mBPTM1.setText(match.getBpTeam1());
        mBPTM2.setText(match.getBpTeam2());

    }
}