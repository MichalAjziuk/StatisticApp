package com.example.statisticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class EditPlayerPanel extends AppCompatActivity {

    private TextView pNameSurname;
    private Button pEditData, pDeletePlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_player_panel);

        pNameSurname = findViewById(R.id.nameSurname);
        pEditData = findViewById(R.id.editData);
        pDeletePlayer = findViewById(R.id.deletePlayer);



    }
}