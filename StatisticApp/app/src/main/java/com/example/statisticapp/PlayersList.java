package com.example.statisticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class PlayersList extends AppCompatActivity {

    private ListView pList;
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_list);

        pList = findViewById(R.id.playerList);

        DatabaseHelper db = new DatabaseHelper(PlayersList.this);
        final List<String> allPlayers = db.getAllPlayers();
        arrayAdapter = new ArrayAdapter<>(PlayersList.this, android.R.layout.simple_list_item_1, allPlayers);
        pList.setAdapter(arrayAdapter);

        pList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(PlayersList.this, PlayerPanel.class);
                intent.putExtra("id", i+1);
                startActivity(intent);
            }
        });
    }
}