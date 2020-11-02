package com.example.statisticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class AddPlayer extends AppCompatActivity {

    private EditText pName, pSurname, pAge, pDateOfBirth, pCountry, pHeight, pWeight, pTeam;
    private Button pSubmit,pBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        pName = findViewById(R.id.name);
        pSurname = findViewById(R.id.surname);
        pAge = findViewById(R.id.age);
        pDateOfBirth = findViewById(R.id.dateofbirth);
        pCountry = findViewById(R.id.country);
        pHeight = findViewById(R.id.height);
        pWeight = findViewById(R.id.weight);
        pTeam = findViewById(R.id.team);

        pSubmit = findViewById(R.id.submit);
        pSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper databaseHelper = new DatabaseHelper(AddPlayer.this);
                String txtName = pName.getText().toString();
                String txtSurname = pSurname.getText().toString();
                String txtAge = pAge.getText().toString();
                String txtDateOfBirth = pDateOfBirth.getText().toString();
                String txtCountry = pCountry.getText().toString();
                String txtHeight = pHeight.getText().toString();
                String txtWeight = pWeight.getText().toString();
                String txtTeam = pTeam.getText().toString();

                if(TextUtils.isEmpty(txtName) || TextUtils.isEmpty(txtSurname) || TextUtils.isEmpty(txtDateOfBirth) || TextUtils.isEmpty(txtCountry) ||
                TextUtils.isEmpty(txtAge) || TextUtils.isEmpty(txtHeight) || TextUtils.isEmpty(txtWeight) || TextUtils.isEmpty(txtTeam)) {
                    Toast.makeText(AddPlayer.this, "Empty credentials!", Toast.LENGTH_SHORT).show();
                } else {
                    Player player = new Player(txtName,txtSurname,txtAge,txtDateOfBirth,txtCountry,txtHeight,txtWeight,txtTeam);
                    databaseHelper.addPlayer(player);
                    Toast.makeText(AddPlayer.this, "You add a player to database", Toast.LENGTH_SHORT).show();
                }
            }
        });

        pBack = findViewById(R.id.backAddPlayer);
        pBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddPlayer.this, AssistantPanel.class));
                finish();
            }
        });
    }
}